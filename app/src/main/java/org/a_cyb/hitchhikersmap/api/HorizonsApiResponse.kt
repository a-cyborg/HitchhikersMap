package org.a_cyb.hitchhikersmap.api

import com.google.gson.annotations.SerializedName

data class HorizonsApiResponse(
    val status: String,

    @SerializedName("result")
    val result: String,
)
