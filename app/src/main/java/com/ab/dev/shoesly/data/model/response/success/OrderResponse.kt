package com.ab.dev.shoesly.data.model.response.success

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderResponse(
    @Json(name = "cart_items")
    val cartItems : List<CartItemResponse>,
    @Json(name = "date_of_order")
    val dateOfOrder: String?,
    @Json(name = "total_price")
    val totalPrice: Float,
    @Json(name = "order_status")
    val orderStatus: String,
    @Json(name = "order_note")
    val orderNote: String,
)
