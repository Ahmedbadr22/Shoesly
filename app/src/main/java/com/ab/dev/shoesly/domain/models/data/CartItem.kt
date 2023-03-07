package com.ab.dev.shoesly.domain.models.data

data class CartItem(
    val id: Int,
    val quantity: Int,
    val stockItem: StockItem
) {
    val totalPrice : Float
        get() = quantity.times(stockItem.shoe.price)

}
