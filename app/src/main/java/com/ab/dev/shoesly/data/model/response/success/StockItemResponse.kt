package com.ab.dev.shoesly.data.model.response.success

import com.ab.dev.shoesly.domain.models.data.StockItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StockItemResponse(
    val id: Int,
    val shoe: ShoeResponse,
    @Json(name = "quantity_in_stock")
    val quantityInStock: Int,
    @Json(name = "colors")
    val colorsList: List<ColorResponse>,
    @Json(name = "sizes")
    val sizesList: List<SizeResponse>,
) {
    fun toStockItem() : StockItem {
        val colors = colorsList.map(ColorResponse::toColor)
        val sizes = sizesList.map(SizeResponse::toSize)
        return StockItem(id, shoe.toShoe(), quantityInStock, colors, sizes)
    }
}