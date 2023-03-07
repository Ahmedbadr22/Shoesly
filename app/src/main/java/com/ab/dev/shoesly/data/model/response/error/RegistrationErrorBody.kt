package com.ab.dev.shoesly.data.model.response.error

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegistrationErrorBody(
    @Json(name = "first_name")
    val firstName: List<String>? = null,
    @Json(name = "last_name")
    val lastName: List<String>? = null,
    @Json(name = "email")
    val email: List<String>? = null,
    @Json(name = "password")
    val password: List<String>? = null
) {

    val firstNameError : String?
        get() = firstName?.get(0)

    val lastNameError : String?
        get() = lastName?.get(0)

    val emailError : String?
        get() = email?.get(0)

    val passwordError : String?
        get() = password?.get(0)
}
