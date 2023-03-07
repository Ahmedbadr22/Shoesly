package com.ab.dev.shoesly.data.model.response.success

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CartItemResponse(
    val id: Int,
    val quantity: Int,
    @Json(name = "stock_item")
    val stockItemResponse: StockItemResponse
)
