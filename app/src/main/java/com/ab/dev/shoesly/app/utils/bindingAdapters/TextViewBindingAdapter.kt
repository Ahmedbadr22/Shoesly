package com.ab.dev.shoesly.app.utils.bindingAdapters

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.NumberFormat
import java.util.*


@BindingAdapter("setPrice")
fun setPrice(view: TextView, price: Float) {
    val formatter = NumberFormat.getCurrencyInstance()
    formatter.currency = Currency.getInstance(Locale.US)
    view.text = formatter.format(price)
}

@BindingAdapter("isChecked")
fun isChecked(view: TextView, isChecked: Boolean) {
    val color : Int = if (isChecked) {
        Color.WHITE
    } else Color.BLACK
    view.setTextColor(color)
}