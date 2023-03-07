package com.ab.dev.shoesly.data.model.response.error

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailError(
    val detail: String
)
