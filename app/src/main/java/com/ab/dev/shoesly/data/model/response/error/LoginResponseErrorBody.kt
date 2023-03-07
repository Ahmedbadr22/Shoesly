package com.ab.dev.shoesly.data.model.response.error

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponseErrorBody(
    @Json(name = "email")
    val email : List<String>?,
    @Json(name = "password")
    val password: List<String>?
) {
    val emailError : String?
        get() = email?.get(0)

    val passwordError : String?
        get() = password?.get(0)
}
