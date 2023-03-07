package com.ab.dev.shoesly.domain.models.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Review(
    val id: Int,
    val body: String,
    val date: String,
    val rate: Float
) : Parcelable
