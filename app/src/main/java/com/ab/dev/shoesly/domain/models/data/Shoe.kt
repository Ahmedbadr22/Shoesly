package com.ab.dev.shoesly.domain.models.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val image: String,
    val brand: Brand,
    val reviews: List<Review>
) : Parcelable {
    val rate: Float
        get() = 0.0F

    val reviewsCount : Int
        get() = reviews.size
}
