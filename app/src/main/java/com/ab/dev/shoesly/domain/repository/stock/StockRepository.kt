package com.ab.dev.shoesly.domain.repository.stock

import com.ab.dev.shoesly.app.utils.result.CallResult
import com.ab.dev.shoesly.domain.models.data.Shoe
import com.ab.dev.shoesly.domain.models.data.StockItem
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    suspend fun listStockItemsFromRemoteAndInsertInLocalByBrandId(brandId: Int)
    suspend fun listStockItemsByBrandIdFlow(brandId: Int) : Flow<List<StockItem>>
}