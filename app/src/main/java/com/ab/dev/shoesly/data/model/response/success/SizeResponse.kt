package com.ab.dev.shoesly.data.model.response.success

import com.ab.dev.shoesly.domain.models.data.Size
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SizeResponse(
    val id: Int,
    val size: Int
) {
    fun toSize() : Size = Size(id, size)
}