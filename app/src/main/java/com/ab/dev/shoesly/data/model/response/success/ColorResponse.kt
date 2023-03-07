package com.ab.dev.shoesly.data.model.response.success

import com.ab.dev.shoesly.domain.models.data.Color
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ColorResponse(
    val id: Int,
    val color: String,
    val hexColor: String
) {
    fun toColor() : Color = Color(id, color, hexColor)
}