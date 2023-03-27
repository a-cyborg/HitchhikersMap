@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.ui.map

import android.graphics.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle.State.STARTED
import androidx.lifecycle.repeatOnLifecycle
import org.a_cyb.hitchhikersmap.models.Planet
import org.a_cyb.hitchhikersmap.ui.components.ThreeDRotationController
import org.a_cyb.hitchhikersmap.ui.theme.HitchhikersMapTheme
import org.a_cyb.hitchhikersmap.util.*

const val XY_ROTATION_SENSITIVITY: Float = 0.003f
const val DEFAULT_OBJECT_RADIUS: Float = 58f

@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    viewModel: MapViewModel = hiltViewModel(),
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val objects by produceState<MapUiState>(
        initialValue = MapUiState.Loading,
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = STARTED) {
            viewModel.mapState.collect { value = it }
        }
    }

    if (objects is MapUiState.Success) {
        MapScreen(
            modifier = modifier.fillMaxSize(),
            objects = (objects as MapUiState.Success).data,
            debugDoubleTap = viewModel::debugDoubleTap,
        )
    }
}

@Composable
internal fun MapScreen(
    modifier: Modifier,
    objects: List<Planet>,
    debugDoubleTap: () -> Unit,
) {
    var scale: Float by rememberSaveable(key = "saveAbleScale") { mutableStateOf(1f) }
    var offsetX: Float by rememberSaveable(key = "saveAbleOffsetX") { mutableStateOf(0f) }
    var offsetY: Float by rememberSaveable(key = "saveAbleOffsetY") { mutableStateOf(0f) }
    var angleX: Float by rememberSaveable(key = "saveAbleAngleX") { mutableStateOf(0f) }
    var angleY: Float by rememberSaveable(key = "saveAbleAngleX") { mutableStateOf(0f) }
    var angleZ: Float by rememberSaveable(key = "saveAbleAngleZ") { mutableStateOf(0f) }

    var xyRotationIsActive by remember { mutableStateOf(false) }

    // Callback of transformable.
    val transformableState = rememberTransformableState(
        onTransformation = { zoomChange, _, rotationChange ->
            scale *= zoomChange
            angleZ += rotationChange
        }
    )

    Box(
        modifier = modifier
            .pointerInput(Unit) {
                detectDragGestures { _, dragAmount ->
                    if (xyRotationIsActive) {
                        // Adjust the x rotation degree when the user drags up or down.
                        angleX += (dragAmount.y * XY_ROTATION_SENSITIVITY)
                        // Adjust y rotation degree when the user drags the left or right.
                        angleY += (dragAmount.x * XY_ROTATION_SENSITIVITY)
                    } else {
                        // Adjust the position of the canvas. Later,it will need to be changed to
                        // adjust the position of the center object.
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        debugDoubleTap()
                    })
            }
            .transformable(state = transformableState)
    ) {
        Canvas(
            modifier = modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offsetX
                    translationY = offsetY
                    rotationZ = angleZ
                }) {

            // Converts the relative position vector(x,y,z) of the object to an offset(x,y).
            val pMatrix = applyXandYRotationAndConvertToOffset(
                objects.map { it.relativeOffset },
                angleX,
                angleY
            ).map { this.center + it }  // Object's offset is relative to the center object.


            if (scale < 0.3f) {
                pMatrix.forEachIndexed { index, offset ->
                    drawCircle(
                        Brush.radialGradient(objects[index].color),
                        DEFAULT_OBJECT_RADIUS,
                        offset)
                }
            } else {
                pMatrix.forEachIndexed { index, offset ->
                    val brush = Brush.radialGradient(objects[index].color)

                    // Create a 3x3 matrix for each object.
                    val cubeMatrix = applyXandYRotationAndConvertToOffset(
                        threeD3x3CubeMatrix(DEFAULT_OBJECT_RADIUS),
                        angleX,
                        angleY
                    ).map { (offset + it) }

                    // Draw two circular lines around the 3x3 cube.
                    drawPath(
                        getTwoCircumferencePathsFor3x3Cube(cubeMatrix),
                        brush,
                        1f,
                        Stroke(3f,
                            3f,
                            StrokeCap.Round,
                            StrokeJoin.Round,
                            PathEffect.dashPathEffect(floatArrayOf(3f, 3f), 3f)
                        )
                    )

                    // Draw the vertices of the cube.
                    drawPoints(cubeMatrix, PointMode.Points, brush, 5f, StrokeCap.Round)
                }
            }
        }

        ThreeDRotationController(
            Modifier
                .padding(23.dp)    // Margin
                .align(Alignment.TopEnd)
                .pointerInput(Unit) {
                    detectTapGestures {
                        xyRotationIsActive = !xyRotationIsActive
                    }
                },
            xyRotationIsActive
        )

//        infoView(
//            modifier = Modifier
//                .padding(23.dp)
//                .align(Alignment.TopStart),
//        )
    }
}

@Composable
fun infoView(modifier: Modifier) {
    Column(modifier = modifier) {
        // System name
        Text(
            text = "Solar System",  // DEV mode
            color = MaterialTheme.colors.primaryVariant,
        )
        // Date and time
        Text(
            text = "position of 2023-03-23",
            color = MaterialTheme.colors.secondary,
        )
    }
}

fun getTwoCircumferencePathsFor3x3Cube(points: List<Offset>): Path {
    return Path().apply {
        // Start from <Front Center>.
        moveTo(points[4].x, points[4].y)

        for (i in 0..1) {
            val step = i * 4
            quadraticBezierTo(
                points[step + 1].x, points[step + 1].y,
                points[step + 10].x, points[step + 10].y)
            quadraticBezierTo(
                points[step + 19].x, points[step + 19].y,
                points[22].x, points[22].y)
            quadraticBezierTo(
                points[25 - step].x, points[25 - step].y,
                points[16 - step].x, points[16 - step].y)
            quadraticBezierTo(
                points[7 - step].x, points[7 - step].y,
                points[4].x, points[4].y)
        }
        close()
    }
}

@Preview
@Composable
fun DefaultPreview() {
    HitchhikersMapTheme {
        MapScreen()
    }
}