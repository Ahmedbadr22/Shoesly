package com.ab.dev.shoesly.app.mappers

import com.ab.dev.shoesly.data.model.entities.stock_item.StockItemEntity
import com.ab.dev.shoesly.data.model.entities.stock_item.StockItemWithShoeAndColorsAndSizes
import com.ab.dev.shoesly.data.model.response.success.ShoeResponse
import com.ab.dev.shoesly.data.model.response.success.StockItemResponse
import com.ab.dev.shoesly.domain.models.data.Color
import com.ab.dev.shoesly.domain.models.data.Shoe
import com.ab.dev.shoesly.domain.models.data.StockItem


fun StockItemResponse.asStockItemEntity() : StockItemEntity {
    return StockItemEntity(id, shoe.id, quantityInStock)
}

fun StockItemResponse.getShoe() : Shoe {
    return Shoe(shoe.id, shoe.title, shoe.description, shoe.price, shoe.image, shoe.brandResponse.toBrand(), emptyList())
}
