package com.ab.dev.shoesly.data.model.response.success

import com.ab.dev.shoesly.domain.models.data.Token
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TokenResponse(
    @Json(name = "access")
    val access: String,
    @Json(name = "refresh")
    val refresh: String
) {
    fun toDomain() : Token {
        return Token(access, refresh)
    }
}
