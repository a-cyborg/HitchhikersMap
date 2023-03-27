@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.a_cyb.hitchhikersmap.models.Planet
import org.a_cyb.hitchhikersmap.ui.map.MapUiState
import org.a_cyb.hitchhikersmap.ui.map.SolarSystemPlanetColor
import org.a_cyb.hitchhikersmap.util.CartesianVector
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiHelper: ApiHelper,
) {
    fun devModeOfflineGetPlanetEphemeris(): Flow<List<Planet>> {
        // Dev mode send
        val testPlanet = flow {
            val eightPlanets = listOf(
                // Coordinate Center Sun
                Planet("Sun", SolarSystemPlanetColor.SUN.colors,
                    130f, CartesianVector(0f, 0f, 0f)
                ),
                // Eight planets.
                Planet("Mercury", SolarSystemPlanetColor.MERCURY.colors,
                    180f, CartesianVector(179f, -32f, -19f)
                ),
                Planet(
                    "Venus", SolarSystemPlanetColor.VENUS.colors,
                    340f, CartesianVector(70.894f, 352.14f, 0.7439f)
                ),
                Planet(
                    "Earth", SolarSystemPlanetColor.EARTH.colors,
                    130f, CartesianVector(-493f, 44.825f, 0.00157f)
                ),
                Planet(
                    "Mars", SolarSystemPlanetColor.MARS.colors,
                    190f, CartesianVector(-440.14f, 687.56f, 25.206f)
                ),
                Planet(
                    "Jupiter", SolarSystemPlanetColor.JUPITER.colors,
                    210f, CartesianVector(2334f, 802.65f, 55.565f)
                ),
                Planet(
                    "Saturn", SolarSystemPlanetColor.SATURN.colors,
                    130f, CartesianVector(4163f, -2572f, -120.94f)
                ),
                Planet("Uranus", SolarSystemPlanetColor.URANUS.colors,
                    130f, CartesianVector(6558f, 7285f, -57.95f)
                ),
                Planet("Neptune", SolarSystemPlanetColor.NEPTUNE.colors,
                    145f, CartesianVector(14850f, -1351f, -314.42f)
                ),
            )

            emit(eightPlanets)
        }

        return testPlanet
    }

//    fun getEightPlanetEphemeris(): Flow<List<Planet>> {
//        val startTime = "2023-03-18"
//        val stopTime = "2023-03-19"
//
//        val mercuryResult = apiHelper.getPlanetEphemeris(199, startTime, stopTime)
//        val VenusResult = apiHelper.getPlanetEphemeris(299, startTime, stopTime)
//        val EarthResult = apiHelper.getPlanetEphemeris(399, startTime, stopTime)
//
//
//        EarthResult.enqueue(object : Callback<PlanetResponse> {
//            override fun onResponse(
//                call: Call<PlanetResponse>,
//                response: Response<PlanetResponse>,
//            ) {
//                Log.d(TAG, "onResponse: ${response.body()}")
//            }
//
//            override fun onFailure(call: Call<PlanetResponse>, t: Throwable) {
//                Log.e(TAG, "onFailure: Error $t")
//                throw Throwable("Api Throw ! ")
//            }
//        })
//
//        val objects: Flow<List<CosmicObject>> = flow {
//            while (true) {
//                val objects = objectApi.fetchCosmicObjects()
//                emit(objects)
//                delay(refreshIntervalMs)  // Suspends the coroutine for some times.
//            }
//        }
//    }
}

