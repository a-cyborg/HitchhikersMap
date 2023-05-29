@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.ui.map

import android.graphics.*
import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle.State.STARTED
import androidx.lifecycle.repeatOnLifecycle
import org.a_cyb.hitchhikersmap.models.CelestialBody
import org.a_cyb.hitchhikersmap.models.XYZVector
import org.a_cyb.hitchhikersmap.ui.components.ThreeDRotationController
import org.a_cyb.hitchhikersmap.ui.components.generateRandomColor
import org.a_cyb.hitchhikersmap.ui.map.MapUiState.*
import org.a_cyb.hitchhikersmap.ui.theme.HitchhikersMapTheme
import org.a_cyb.hitchhikersmap.util.*

const val XY_ROTATION_SENSITIVITY: Float = 0.003f
const val DEFAULT_OBJECT_RADIUS: Float = 58f
const val TAG: String = "MapScreen"

@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    viewModel: MapViewModel = hiltViewModel(),
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val state by produceState<MapUiState>(
        initialValue = Loading("Ready"),
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = STARTED) {
            viewModel.mapState.collect { value = it }
        }
    }

    when (state) {
        is Loading -> {
            Log.d(TAG, "MapScreen: is loading = ${(state as Loading).info}")
            LoadingScreen((state as Loading).info)
        }

        is Success -> {
            MapScreen(
                modifier = modifier.fillMaxSize(),
                bodies = (state as Success).data,
                debugDoubleTap = viewModel::debugDoubleTap,
            )
        }

        is Error -> {
            // TODO: Create error handling screen
            Log.e(
                TAG, "MapScreen: ${(state as Error).throwable.message} +" +
                        "${(state as Error).throwable.stackTrace}"
            )
        }
    }
}

@Composable
internal fun LoadingScreen(infoMessage: String) {
    Text(
        text = infoMessage,
        modifier = Modifier.background(androidx.compose.ui.graphics.Color.Blue),
        textAlign = TextAlign.Center,
        fontSize = 30.sp
    )
}

@Composable
internal fun MapScreen(
    modifier: Modifier,
    bodies: List<CelestialBody>,
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

//            drawCelestialBody(bodies)

            // Draw the sun.
            drawCircle(
                color = androidx.compose.ui.graphics.Color.Yellow,
                radius = 15f,
                center = center,
                style = Stroke(width = 2f)
            )

            // Converts the relative position vector(x,y,z) of the object to an offset(x,y).
            val pMatrix = applyXandYRotationAndConvertToOffset(
                bodies.map { it.positions[0].xyz },
                angleX,
                angleY
            ).map { this.center + it }  // Object's offset is relative to the center object.

//            if (scale < 0.3f) {
//                pMatrix.forEachIndexed { index, offset ->
//                    drawCircle(
//                        Brush.radialGradient(objects[index].color),
//                        DEFAULT_OBJECT_RADIUS,
//                        offset
//                    )
//                }
//            } else {
            pMatrix.forEachIndexed { index, offset ->
                val brush = Brush.radialGradient(
                    listOf(generateRandomColor(), generateRandomColor(), generateRandomColor())
                )

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
                    Stroke(
                        3f,
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

        // FIXME: Let's use for drawscope?? and then remove all the modifier 
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
                points[step + 10].x, points[step + 10].y
            )
            quadraticBezierTo(
                points[step + 19].x, points[step + 19].y,
                points[22].x, points[22].y
            )
            quadraticBezierTo(
                points[25 - step].x, points[25 - step].y,
                points[16 - step].x, points[16 - step].y
            )
            quadraticBezierTo(
                points[7 - step].x, points[7 - step].y,
                points[4].x, points[4].y
            )
        }
        close()
    }
}

fun devModeVectors() = listOf(
    XYZVector(0f, 0f, 0f),
    XYZVector(179f, -32f, -19f),
    XYZVector(70.894f, 352.14f, 0.7439f),
    XYZVector(-493f, 44.825f, 0.00157f),
    XYZVector(-440.14f, 687.56f, 25.206f),
    XYZVector(2334f, 802.65f, 55.565f),
    XYZVector(4163f, -2572f, -120.94f),
    XYZVector(6558f, 7285f, -57.95f),
    XYZVector(14850f, -1351f, -314.42f),
)

@Preview
@Composable
fun DefaultPreview() {
    HitchhikersMapTheme {
        MapScreen()
    }
}