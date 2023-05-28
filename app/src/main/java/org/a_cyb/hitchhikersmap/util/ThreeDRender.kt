package org.a_cyb.hitchhikersmap.util

import androidx.compose.ui.geometry.Offset
import org.a_cyb.hitchhikersmap.models.XYZVector
import kotlin.math.cos
import kotlin.math.sin



/**
 * This function simply returns (Android) Offset instance as (self.x, self.y) ignores z value.
 */
fun XYZVector.toOffset(): Offset {
    return Offset(x, y)
}

/*
Implementation of 3D Rendering with Rotation and Projection.
https://thecodingtrain.com
 */

private val projectionMatrix: List<XYZVector> = listOf(
    XYZVector(1f, 0f, 0f),
    XYZVector(0f, 1f, 0f),
)

private fun zRotationMatrix(angle: Float): List<XYZVector> = listOf(
    XYZVector(cos(angle), -sin(angle), 0f),
    XYZVector(sin(angle), cos(angle), 0f),
    XYZVector(0f, 0f, 1f)
)

private fun xRotationMatrix(angle: Float): List<XYZVector> = listOf(
    XYZVector(1f, 0f, 0f),
    XYZVector(0f, cos(angle), -sin(angle)),
    XYZVector(0f, sin(angle), cos(angle))
)

private fun yRotationMatrix(angle: Float): List<XYZVector> = listOf(
    XYZVector(cos(angle), 0f, -sin(angle)),
    XYZVector(0f, 1f, 0f),
    XYZVector(sin(angle), 0f, cos(angle))
)

private fun applyXRotation(angle: Float, targetV: List<XYZVector>) =
    matrixMultiple(targetV, xRotationMatrix(angle))

private fun applyYRotation(angle: Float, targetV: List<XYZVector>) =
    matrixMultiple(targetV, yRotationMatrix(angle))

private fun matrixMultiple(
    targetV: List<XYZVector>,
    sourceV: List<XYZVector>,
): List<XYZVector> {
    val result = mutableListOf<XYZVector>()

    targetV.forEach { (targetX, targetY, targetZ) ->
        val x =
            (targetX * sourceV[0].x) + (targetY * sourceV[0].y) + (targetZ * sourceV[0].z)
        val y =
            (targetX * sourceV[1].x) + (targetY * sourceV[1].y) + (targetZ * sourceV[1].z)
        val z = if (sourceV.size > 2) {
            (targetX * sourceV[2].x) + (targetY * sourceV[2].y) + (targetZ * sourceV[2].z)
        } else 0f

        result.add(XYZVector(x, y, z))
    }
    return result
}

fun applyXandYRotationAndConvertToOffset(
    targetV: List<XYZVector>,
    xAngle: Float,
    yAngle: Float,
): List<Offset> {
    val rotatedMatrix = applyXRotation(xAngle, applyYRotation(yAngle, targetV))

    return matrixMultiple(rotatedMatrix, projectionMatrix)
        .map { it.toOffset() }
}

/**
 * Generate 3x3 3D cube matrix.
 */
fun threeD3x3CubeMatrix(radius: Float): List<XYZVector> {
    val matrix = mutableListOf<XYZVector>()

    for (i in 0..2) {
        for (j in 0..2) {
            for (c in 0..2) {
                matrix += listOf(
                    XYZVector(
                        radius - (radius * c),
                        radius - (radius * j),
                        radius - (radius * i)
                    ),
                )
            }
        }
    }
    return matrix
}




