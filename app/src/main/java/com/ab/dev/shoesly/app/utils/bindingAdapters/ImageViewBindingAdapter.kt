package com.ab.dev.shoesly.app.utils.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.ab.dev.shoesly.R


@BindingAdapter("setImageUrl")
fun setImageUrl(view: ImageView, url: String) {
    view.load(url)
}

@BindingAdapter("isChecked")
fun isChecked(view: ImageView, isChecked: Boolean) {
    if (isChecked) view.setImageResource(R.drawable.icon_true)
    else view.setImageDrawable(null)
}