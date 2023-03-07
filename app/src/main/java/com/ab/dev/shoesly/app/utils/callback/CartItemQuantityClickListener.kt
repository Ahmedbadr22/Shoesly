package com.ab.dev.shoesly.app.utils.callback

interface CartItemQuantityClickListener<T> {
    fun onMinus(item: T)
    fun onPlus(item: T)
}