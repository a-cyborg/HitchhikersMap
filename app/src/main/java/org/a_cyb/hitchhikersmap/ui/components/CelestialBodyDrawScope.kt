package org.a_cyb.hitchhikersmap.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import org.a_cyb.hitchhikersmap.models.CelestialBody
import org.a_cyb.hitchhikersmap.models.CelestialBodyType
import java.util.Random


//    val radius = SUN_RADIUS * RADIUS_SCALING_FACTOR,
//    val mercuryX = (centerX + (2.172367429497835E+07 * DISTANCE_SCALING_FACTOR)).toFloat()
//    val mercuryY = (centerY + (-6.321748818053888E+07 * DISTANCE_SCALING_FACTOR)).toFloat()

fun DrawScope.drawCelestialBody(
    bodies: List<CelestialBody>,
) {
    val distanceScalingFactor = (1 / 900000.0).toFloat()
//    val radiusScalingFactor = (7 / 90000.0).toFloat() // km
//    val SUN_RADIUS = 695700f
    // Draw the sun.
    drawCircle(
        color = Color.Yellow,
        radius = 15f,
        center = center,
        style = Stroke(width = 2f)
    )

    for (body in bodies) {
        var radius = 13f
        if (body.name == "Moon") radius = 5f

        val x = (center.x + (body.positions[0].xyz.x * distanceScalingFactor))
        val y = (center.y + (body.positions[0].xyz.y * distanceScalingFactor))


        drawCircle(
            color = generateRandomColor(),
            radius = radius,
            center = Offset(x, y),
            style = Stroke(width = 2f)
        )
    }

    // TODO: Draw natural satellite
    // Moon + other planet's satellite
}

internal fun drawCentralBody() {

}

@Composable
internal fun drawOrbitalBody() {

}

fun generateRandomColor(): Color {
    val random = Random()
    val alpha = 255
    val red = random.nextInt(256)
    val green = random.nextInt(256)
    val blue = random.nextInt(256)
    return Color(red, green, blue, alpha)
}
