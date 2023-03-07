package com.ab.dev.shoesly.data.source.local.source.size

import com.ab.dev.shoesly.data.model.entities.size.SizeEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeStockItemEntity

interface SizeLocalDataSource {

    suspend fun insertSize(sizeEntity: SizeEntity)
    suspend fun insertSizesList(sizeEntityList: List<SizeEntity>)
    suspend fun listSizes() : List<SizeEntity>
    suspend fun getSizeEntityById(sizeId: Int) : SizeEntity


    // Size Stock Item
    suspend fun insertSizeStockItemEntity(sizeStockItemEntity: SizeStockItemEntity)

    suspend fun insertSizeStockItemEntityList(sizeStockItemEntityList: List<SizeStockItemEntity>)

    fun listSizesIdOfSizeStockItemListByStockItemId(stockItemId: Int) : List<Int>
}