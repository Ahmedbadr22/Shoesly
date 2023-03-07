package com.ab.dev.shoesly.domain.models.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Color(
    val id: Int,
    val color: String,
    val hexColor: String,
    var isChecked: Boolean = false
) : Parcelable
