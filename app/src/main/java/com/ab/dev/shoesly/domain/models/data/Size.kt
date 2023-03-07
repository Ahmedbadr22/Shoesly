package com.ab.dev.shoesly.domain.models.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Size(
    val id: Int,
    val size: Int,
    var isChecked: Boolean = false
) : Parcelable
