@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/horizons.api")
    fun getPlanetEphemeris(
        @Query("format") format: String = "json",
        @Query("COMMAND") command: Int,
        @Query("CENTER") center: String = "500@10",  // Sun is default center
        @Query("OBJ_DATA") objData: String = "YES",
        @Query("EPHEM_TYPE") ephemType: String = "VECTORS",
        @Query("START_TIME") startTime: String,
        @Query("STOP_TIME") stopTime: String,
        @Query("VEC_TABLE") vecTable: Int = 1, // Position components(x,y,z) only.
        @Query("CAL_FORMAT") calFormat: String = "CAL", //type of data output for calender date/time
        @Query("CAL_TYPE") calType: String = "GREGORIAN",
    ): Call<PlanetResponse>
}

