package com.ab.dev.shoesly.domain.repository.color

import com.ab.dev.shoesly.data.model.entities.color.ColorEntity
import com.ab.dev.shoesly.data.model.entities.color.ColorStockItemEntity

interface ColorRepository {
    suspend fun getColorsFromRemoteAndInsertToLocalDataSource()

    suspend fun insertColorStockItemEntity(colorStockItemEntity: ColorStockItemEntity)

    suspend fun insertColorStockItemEntityList(colorStockItemEntityList: List<ColorStockItemEntity>)

    fun listColorsEntityIdByStockItemId(stockItemId: Int) : List<Int>
    suspend fun listColorsEntityListByStockItemId(stockItemId: Int) : List<ColorEntity>
}