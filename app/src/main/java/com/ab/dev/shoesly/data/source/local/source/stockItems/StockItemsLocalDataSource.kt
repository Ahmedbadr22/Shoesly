package com.ab.dev.shoesly.data.source.local.source.stockItems

import com.ab.dev.shoesly.data.model.entities.stock_item.StockItemEntity
import com.ab.dev.shoesly.data.model.entities.stock_item.StockItemWithShoeAndColorsAndSizes
import kotlinx.coroutines.flow.Flow


interface StockItemsLocalDataSource {

    suspend fun insertStockItem(stockItemEntity: StockItemEntity)
    suspend fun insertStockItems(items: List<StockItemEntity>)
    fun listStockItemsFlow() : Flow<List<StockItemWithShoeAndColorsAndSizes>>
    fun listStockItemsByBrandId(brandId: Int) : List<StockItemWithShoeAndColorsAndSizes>
}