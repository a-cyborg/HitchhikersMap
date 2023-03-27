@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.api

import retrofit2.Call

interface ApiHelper {
    fun getPlanetEphemeris(
        target: Int,
        startTime: String,
        stopTime: String,
    ): Call<PlanetResponse>
}


