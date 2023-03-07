package com.ab.dev.shoesly.data.model.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegistrationRequest(
    @Json(name = "first_name")
    var firstName: String,
    @Json(name = "last_name")
    var lastName: String,
    @Json(name = "email")
    var email: String,
    @Json(name = "password")
    var password: String
)
