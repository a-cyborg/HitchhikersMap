@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.ui.map

import androidx.compose.ui.graphics.Color

enum class SolarSystemPlanetColor(val colors: List<Color>) {
    SUN(
        listOf(
            Color(0xFFFF0000),
            Color(0xFFF36900),
            Color(0xFFFFF200),
            Color(0xFF448600),
            Color(0xFF000EFF),
            Color(0xFF000080),
            Color(0xFF9B30FF),
        ),
    ),
    MERCURY(
        listOf(
            Color(0xFF707070),
            Color(0xFFE7EEFF),
        )
    ),
    VENUS(
        listOf(
            Color(0xFFE8BC5B),
            Color(0xFF92461F),
        )
    ),
    EARTH(
        listOf(
            Color(0xFF263257),
            Color(0xFF2D656B),
            Color(0xFF3DEF23),
            Color(0xFF001AFF),
        )
    ),
    MARS(
        listOf(
            Color(0xFF7A1A15),
            Color(0xFFC7642E),
            Color(0xFFB44C27)// White
        )
    ),
    JUPITER(
        listOf(
            Color(0xFF86735B),
            Color(0xFF9C7C55),
            Color(0xFF90A0B6)
        )
    ),
    SATURN(
        listOf(
            Color(0xFFD4CCAF),
            Color(0xFF7C7568),
            Color(0xFF292823)
        )
    ),
    URANUS(
        listOf(
            Color(0xFFD2F8F9),
            Color(0xFFE7EEFF)
        )
    ),
    NEPTUNE(
        listOf(
            Color(0xFF6991E5),
            Color(0xFFE7EEFF)
        )
    ),
    MOON(
        listOf(
            Color(0xFFFFE331),
            Color(0xFF000000),
            Color(0xFFFFDF00)
        )
    ),
    DEFAULT(
        listOf(
            Color(0xFFFFE331),
            Color(0xFF000000),
            Color(0xFFFFDF00)

        )
    )
}
