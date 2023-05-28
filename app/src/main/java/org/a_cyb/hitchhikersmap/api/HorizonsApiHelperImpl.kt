@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.api

import retrofit2.Call
import javax.inject.Inject

class HorizonsApiHelperImpl @Inject constructor(private val apiService: HorizonsApiService) :
    HorizonsApiHelper {
    override suspend fun getBodyEphemeris(
        target: Int,
        startTime: String,
        stopTime: String,
        stepSize: String,
    ): Call<HorizonsApiResponse> =
        apiService.getPlanetEphemeris(
            command = target,
            startTime = startTime,
            stopTime = stopTime,
            stepSize = stepSize,
        )
}