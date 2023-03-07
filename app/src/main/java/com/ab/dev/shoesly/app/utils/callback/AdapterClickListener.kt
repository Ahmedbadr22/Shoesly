package com.ab.dev.shoesly.app.utils.callback


class AdapterClickListener<T>(val clickListener: (data: T) -> Unit) {
    fun onClick(data: T) = clickListener(data)
}