@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.api

import android.util.Log
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

//    fun getDummyBodyEphemeris(
//        target: Int,
//    ): Call<HorizonsApiResponse> {
//        return object : Call<HorizonsApiResponse> {
//            override fun enqueue(callback: Callback<HorizonsApiResponse>) {
//                // Invoke the success callback with the dummy response
//                callback.onResponse(this, Response.success(HorizonsApiResponse("good", "awesome")))
//            }
//
//            override fun isExecuted(): Boolean {
//                return false
//            }
//        }
//    }
}