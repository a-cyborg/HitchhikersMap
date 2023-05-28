package org.a_cyb.hitchhikersmap.api

enum class HorizonsApiBodyId(val id: Int) {
    // Major bodies
    // Sun(10),
    Mercury(199),
    Venus(299),
    Earth(399),
    Mars(499),
    Jupiter(599),
    Saturn(699),
    Uranus(799),
    Neptune(899),

    // Small bodies
    Moon(301),
    // TODO: Add another natural satellite
}

// Dev mode default list of <CelestialBody>
//    fun devModeOfflineGetPlanetEphemeris(): Flow<List<Planet>> {
//        // Dev mode send
//        val testPlanet = flow {
//            val eightPlanets = listOf(
//                // Coordinate Center Sun
//                Planet("Sun", SolarSystemPlanetColor.SUN.colors,
//                    130f, CartesianVector(0f, 0f, 0f)
//                ),
//                // Eight planets.
//                Planet("Mercury", SolarSystemPlanetColor.MERCURY.colors,
//                    180f, CartesianVector(179f, -32f, -19f)
//                ),
//                Planet(
//                    "Venus", SolarSystemPlanetColor.VENUS.colors,
//                    340f, CartesianVector(70.894f, 352.14f, 0.7439f)
//                ),
//                Planet(
//                    "Earth", SolarSystemPlanetColor.EARTH.colors,
//                    130f, CartesianVector(-493f, 44.825f, 0.00157f)
//                ),
//                Planet(
//                    "Mars", SolarSystemPlanetColor.MARS.colors,
//                    190f, CartesianVector(-440.14f, 687.56f, 25.206f)
//                ),
//                Planet(
//                    "Jupiter", SolarSystemPlanetColor.JUPITER.colors,
//                    210f, CartesianVector(2334f, 802.65f, 55.565f)
//                ),
//                Planet(
//                    "Saturn", SolarSystemPlanetColor.SATURN.colors,
//                    130f, CartesianVector(4163f, -2572f, -120.94f)
//                ),
//                Planet("Uranus", SolarSystemPlanetColor.URANUS.colors,
//                    130f, CartesianVector(6558f, 7285f, -57.95f)
//                ),
//                Planet("Neptune", SolarSystemPlanetColor.NEPTUNE.colors,
//                    145f, CartesianVector(14850f, -1351f, -314.42f)
//                ),
//            )
//
//            emit(eightPlanets)
//        }
//
//        return testPlanet
//    }
