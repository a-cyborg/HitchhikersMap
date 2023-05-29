package org.a_cyb.hitchhikersmap.api

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.a_cyb.hitchhikersmap.ui.map.MapUiState
import org.a_cyb.hitchhikersmap.ui.map.TAG
import org.a_cyb.hitchhikersmap.util.parseHorizonsApiResponses
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiHelper: HorizonsApiHelper,
) {
    /**
     * Function to fetch the ephemeris data for celestial bodies in the Solar System
     * at a specific time using Flow.
     *
     * @param startTime: String
     * @param stopTime: String
     * @param stepSize: String
     * @return MapUiState
     */
    fun fechAndParseEphemerisOfSolarBodies(
        startTime: String = "2023-03-18",
        stopTime: String = "2023-03-19",
        stepSize: String = "12h",
    ): Flow<MapUiState> = flow {
        val responses = mutableListOf<String>()

        for (body in HorizonsApiBodyId.values()) {
            emit(MapUiState.Loading("Fetching position of ${body.name}..."))

            try {
                // DEV MODE
                val response = fetchEphemeris(body.id, startTime, stopTime, stepSize)
                responses.add(response)

                delay(200)
            } catch (e: Exception) {
                // TODO: Default data in case something not working.
                // TODO: Implements proper error handling.
                Log.e(
                    TAG, "fetchSolarBodyPositionsWithHorizonsApi: " +
                            "${e.message} \n ${e.stackTrace}"
                )

                emit(MapUiState.Error(Throwable(e.message)))
            }
        }

        // Parse the responses
        emit(MapUiState.Loading("Parsing the responses..."))
        val bodies = parseHorizonsApiResponses(responses)

        emit(MapUiState.Success(bodies))
    }

    // fetchSolarBodyEphemeris
    private suspend fun fetchEphemeris(
        id: Int,
        startTime: String,
        stopTime: String,
        stepSize: String,
    ): String {
        val response =
            apiHelper.getBodyEphemeris(id, startTime, stopTime, stepSize).execute()

        // TODO: What to do when response is not successful.
        return if (response.isSuccessful) response.body()?.result.toString() else {
            ""
        }
    }

    fun fetchDummySolarBodyPositions(): Flow<MapUiState> = flow {
        val responses = dummyHorizonApiResponseResults
        Log.d(TAG, "fetchDummySolarBodyPositions: $responses")

        // Parse the responses
        emit(MapUiState.Loading("Parsing the responses..."))
        val bodies = parseHorizonsApiResponses(responses)

        emit(MapUiState.Success(bodies))
    }
}