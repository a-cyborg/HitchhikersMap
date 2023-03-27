package org.a_cyb.hitchhikersmap.util

import androidx.compose.ui.geometry.Offset
import kotlin.math.cos
import kotlin.math.sin

/**
 * Defines a 3D vector that contains three float value fields.
 */
data class CartesianVector(val x: Float, var y: Float, var z: Float)

/**
 * This function simply returns (Android) Offset instance as (self.x, self.y) ignores z value.
 */
fun CartesianVector.toOffset(): Offset {
    return Offset(x, y)
}

/*
Implementation of 3D Rendering with Rotation and Projection.
https://thecodingtrain.com
 */

private val projectionMatrix: List<CartesianVector> = listOf(
    CartesianVector(1f, 0f, 0f),
    CartesianVector(0f, 1f, 0f),
)

private fun zRotationMatrix(angle: Float): List<CartesianVector> = listOf(
    CartesianVector(cos(angle), -sin(angle), 0f),
    CartesianVector(sin(angle), cos(angle), 0f),
    CartesianVector(0f, 0f, 1f)
)

private fun xRotationMatrix(angle: Float): List<CartesianVector> = listOf(
    CartesianVector(1f, 0f, 0f),
    CartesianVector(0f, cos(angle), -sin(angle)),
    CartesianVector(0f, sin(angle), cos(angle))
)

private fun yRotationMatrix(angle: Float): List<CartesianVector> = listOf(
    CartesianVector(cos(angle), 0f, -sin(angle)),
    CartesianVector(0f, 1f, 0f),
    CartesianVector(sin(angle), 0f, cos(angle))
)

private fun applyXRotation(angle: Float, targetV: List<CartesianVector>) =
    matrixMultiple(targetV, xRotationMatrix(angle))

private fun applyYRotation(angle: Float, targetV: List<CartesianVector>) =
    matrixMultiple(targetV, yRotationMatrix(angle))

private fun matrixMultiple(
    targetV: List<CartesianVector>,
    sourceV: List<CartesianVector>,
): List<CartesianVector> {
    val result = mutableListOf<CartesianVector>()

    targetV.forEach { (targetX, targetY, targetZ) ->
        val x =
            (targetX * sourceV[0].x) + (targetY * sourceV[0].y) + (targetZ * sourceV[0].z)
        val y =
            (targetX * sourceV[1].x) + (targetY * sourceV[1].y) + (targetZ * sourceV[1].z)
        val z = if (sourceV.size > 2) {
            (targetX * sourceV[2].x) + (targetY * sourceV[2].y) + (targetZ * sourceV[2].z)
        } else 0f

        result.add(CartesianVector(x, y, z))
    }
    return result
}

fun applyXandYRotationAndConvertToOffset(
    targetV: List<CartesianVector>,
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
fun threeD3x3CubeMatrix(radius: Float): List<CartesianVector> {
    val matrix = mutableListOf<CartesianVector>()

    for (i in 0..2) {
        for (j in 0..2) {
            for (c in 0..2) {
                matrix += listOf(
                    CartesianVector(
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




