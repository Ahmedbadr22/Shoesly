package com.ab.dev.shoesly.data.model.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TokenVerifyRequest(
    @Json(name = "token")
    val token: String
)
