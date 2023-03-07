package com.ab.dev.shoesly.domain.models.data

data class Token(
    var access: String,
    var refresh: String
) {
    val bearerAccessToken: String
        get() = "Bearer $access"
}
