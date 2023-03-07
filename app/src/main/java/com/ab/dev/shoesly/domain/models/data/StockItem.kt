package com.ab.dev.shoesly.domain.models.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockItem(
    val id: Int,
    val shoe: Shoe,
    val quantityInStock: Int,
    val colors: List<Color>,
    val sizes: List<Size>,
) : Parcelable
