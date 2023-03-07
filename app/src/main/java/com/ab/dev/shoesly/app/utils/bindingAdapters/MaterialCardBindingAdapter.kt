package com.ab.dev.shoesly.app.utils.bindingAdapters

import android.graphics.Color
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView


@BindingAdapter("setStringColorAsCardBackgroundColor")
fun setStringColorAsCardBackgroundColor(view: MaterialCardView, stringColor: String) {
    view.setCardBackgroundColor(Color.parseColor(stringColor))
}

@BindingAdapter("isChecked")
fun isChecked(view: MaterialCardView, isChecked: Boolean) {
    val color = if (isChecked) Color.BLACK
    else Color.WHITE

    view.setCardBackgroundColor(color)
}