package com.ab.dev.shoesly.domain.models.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Brand(
    val id: Int,
    val name: String,
    val logo: String
) : Parcelable
