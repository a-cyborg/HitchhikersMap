@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.models

import androidx.compose.ui.graphics.Color
import java.time.LocalDateTime

data class CelestialBody(
    val name: String,
    val radius: Float,
    val positions: List<CelestialPosition>,
    val colors: List<Color> = listOf(Color.Blue),
)

data class CelestialPosition(
    val dateAndTime: LocalDateTime,
    val xyz: XYZVector
)

data class XYZVector(
    val x: Float,
    var y: Float,
    var z: Float
)
