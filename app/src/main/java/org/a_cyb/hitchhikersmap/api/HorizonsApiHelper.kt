@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.api

import retrofit2.Call

interface HorizonsApiHelper {
    suspend fun getBodyEphemeris(
        target: Int,
        startTime: String,
        stopTime: String,
        stepSize: String,
    ): Call<HorizonsApiResponse>
}