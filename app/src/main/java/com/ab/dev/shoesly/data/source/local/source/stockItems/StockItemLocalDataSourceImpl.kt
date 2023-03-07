package com.ab.dev.shoesly.data.source.local.source.stockItems

import com.ab.dev.shoesly.data.model.entities.stock_item.StockItemEntity
import com.ab.dev.shoesly.data.model.entities.stock_item.StockItemWithShoeAndColorsAndSizes
import com.ab.dev.shoesly.data.source.local.db.dao.StockItemDao
import kotlinx.coroutines.flow.Flow

class StockItemLocalDataSourceImpl(
    private val stockItemDao: StockItemDao
) : StockItemsLocalDataSource {
    override suspend fun insertStockItem(stockItemEntity: StockItemEntity) {
        stockItemDao.insertStockItem(stockItemEntity)
    }

    override suspend fun insertStockItems(items: List<StockItemEntity>) {
        stockItemDao.insertStockItems(items)
    }

    override fun listStockItemsFlow(): Flow<List<StockItemWithShoeAndColorsAndSizes>> {
        return stockItemDao.listStockItemsFlow()
    }

    override fun listStockItemsByBrandId(brandId: Int): List<StockItemWithShoeAndColorsAndSizes> {
        return stockItemDao.listStockItemsByBrandIdFlow(brandId)
    }

}