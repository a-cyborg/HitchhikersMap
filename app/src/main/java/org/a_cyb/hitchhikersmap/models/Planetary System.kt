package org.a_cyb.hitchhikersmap.models

data class PlanetarySystem (
    val name: String,
    val coordinate: Pair<Float, Float>,
    val planets: List<Planet>,
)
