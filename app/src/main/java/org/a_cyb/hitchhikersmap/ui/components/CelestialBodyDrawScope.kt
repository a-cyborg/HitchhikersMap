package org.a_cyb.hitchhikersmap.ui.components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import org.a_cyb.hitchhikersmap.models.CelestialBody
import java.util.Random

private const val DISTANCE_SCALING_FACTOR = (1 / 1_000_000.0).toFloat() // float
private const val RADIUS_SCALING_FACTOR = (7 / 100_000.0).toFloat() // km
private const val SUN_RADIUS = 695700f

//    val radius = SUN_RADIUS * RADIUS_SCALING_FACTOR,
//    val mercuryX = (centerX + (2.172367429497835E+07 * DISTANCE_SCALING_FACTOR)).toFloat()
//    val mercuryY = (centerY + (-6.321748818053888E+07 * DISTANCE_SCALING_FACTOR)).toFloat()
fun DrawScope.drawCelestialBody(
    drawScope: DrawScope,
    bodies: List<CelestialBody>
) {
    val centerX = size.width / 2
    val centerY = size.height / 2

    // Draw the sun.
    drawCircle(
        color = Color.Yellow,
        radius = 30f,
        center = Offset(centerX, centerY),  // The Sun is center.
        style = Stroke(width = 2f)
    )

    // Draw bodies.
    for (body in bodies) {
//        val radius = body.radius * RADIUS_SCALING_FACTOR
        val x = (centerX + (body.positions[0].xyz.x * DISTANCE_SCALING_FACTOR))
        val y = (centerY + (body.positions[0].xyz.y * DISTANCE_SCALING_FACTOR))

        drawCircle(
            color = generateRandomColor(),
            radius = 30f,
            center = Offset(x, y),
            style = Stroke(width = 2f)
        )
    }
}

private fun generateRandomColor(): Color {
    val random = Random()
    val alpha = 255
    val red = random.nextInt(256)
    val green = random.nextInt(256)
    val blue = random.nextInt(256)
    return Color(red, green, blue, alpha)
}
