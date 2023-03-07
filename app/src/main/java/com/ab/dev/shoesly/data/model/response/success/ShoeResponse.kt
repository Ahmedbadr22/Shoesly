package com.ab.dev.shoesly.data.model.response.success

import com.ab.dev.shoesly.domain.models.data.Shoe
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShoeResponse(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val price: Float,
    @Json(name = "brand")
    val brandResponse: BrandResponse,
    @Json(name = "reviews")
    val reviewsList: List<ReviewResponse>
) {
    fun toShoe(): Shoe {
        val reviews = reviewsList.map { reviewResponse -> reviewResponse.toReview() }
        return Shoe(id, title, description, price, image, brandResponse.toBrand(), reviews)
    }
}
