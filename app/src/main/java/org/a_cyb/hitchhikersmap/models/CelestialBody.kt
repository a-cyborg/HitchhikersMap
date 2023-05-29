@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.models

import androidx.compose.ui.graphics.Color
import java.time.LocalDateTime

data class CelestialBody(
    val name: String,
    val radius: Float,
    val positions: List<CelestialPosition>,
    val type: CelestialBodyType = CelestialBodyType.PLANET,
    val colors: List<Color> = listOf(Color.Blue),
)

enum class CelestialBodyType { STAR, PLANET, NATURAL_SATELLITE, ASTEROID, COMET, }
data class CelestialPosition(val dateAndTime: LocalDateTime, var xyz: XYZVector)
data class XYZVector(var x: Float, var y: Float, var z: Float) {
    fun multiply(multiplier: Float): XYZVector {
        return XYZVector(x * multiplier, y * multiplier, z * multiplier)
    }
}
