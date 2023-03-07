package com.ab.dev.shoesly.data.model.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "email")
    var email: String,
    @Json(name = "password")
    var password: String
)
