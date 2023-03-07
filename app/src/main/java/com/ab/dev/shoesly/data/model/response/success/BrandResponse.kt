package com.ab.dev.shoesly.data.model.response.success

import com.ab.dev.shoesly.domain.models.data.Brand
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BrandResponse(
    val id: Int,
    val name: String,
    val logo: String
) {
    fun toBrand() : Brand {
        return Brand(id, name, logo)
    }
}