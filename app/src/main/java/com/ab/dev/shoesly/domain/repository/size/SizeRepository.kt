package com.ab.dev.shoesly.domain.repository.size


import com.ab.dev.shoesly.data.model.entities.size.SizeEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeStockItemEntity

interface SizeRepository {
    suspend fun getSizesFromRemoteAndInsertToLocalDataSource()

    suspend fun insertSizeStockItemEntity(sizeStockItemEntity: SizeStockItemEntity)

    suspend fun insertSizeStockItemEntityList(sizeStockItemEntityList: List<SizeStockItemEntity>)

    fun listSizesEntityIdByStockItemId(stockItemId: Int) : List<Int>

    suspend fun listSizesEntityListByStockItemId(stockItemId: Int) : List<SizeEntity>
}