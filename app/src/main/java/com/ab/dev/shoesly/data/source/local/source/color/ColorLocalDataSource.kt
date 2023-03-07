package com.ab.dev.shoesly.data.source.local.source.color

import com.ab.dev.shoesly.data.model.entities.color.ColorEntity
import com.ab.dev.shoesly.data.model.entities.color.ColorStockItemEntity

interface ColorLocalDataSource {
    suspend fun insertColor(colorEntity: ColorEntity)
    suspend fun insertColorsList(colorEntityList: List<ColorEntity>)
    fun listColors() : List<ColorEntity>
    suspend fun getColorEntityById(colorId: Int) : ColorEntity
    suspend fun listColorsEntityByStockItemId(stockItemId: Int) : List<ColorEntity>

    // Color Stock Item
    suspend fun insertColorStockItemEntity(colorStockItemEntity: ColorStockItemEntity)

    suspend fun insertColorStockItemEntityList(colorStockItemEntityList: List<ColorStockItemEntity>)

    fun listColorsEntityIdByStockItemId(stockItemId: Int) : List<Int>
}