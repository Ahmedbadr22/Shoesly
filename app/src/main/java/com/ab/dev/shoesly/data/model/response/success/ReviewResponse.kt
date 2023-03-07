package com.ab.dev.shoesly.data.model.response.success

import com.ab.dev.shoesly.domain.models.data.Review
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReviewResponse(
    val id: Int,
    val body: String,
    val date: String,
    val rate: Float
) {
    fun toReview() : Review {
        return Review(id, body, date, rate)
    }
}
