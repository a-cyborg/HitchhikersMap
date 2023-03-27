@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.api

import retrofit2.Call
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override fun getPlanetEphemeris(
        target: Int,
        startTime: String,
        stopTime: String,
    ): Call<PlanetResponse> =
        apiService.getPlanetEphemeris(
            command = target,
            startTime = startTime,
            stopTime = stopTime
        )
}