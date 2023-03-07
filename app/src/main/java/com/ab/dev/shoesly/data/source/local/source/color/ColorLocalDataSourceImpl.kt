package com.ab.dev.shoesly.data.source.local.source.color

import com.ab.dev.shoesly.data.model.entities.color.ColorEntity
import com.ab.dev.shoesly.data.model.entities.color.ColorStockItemEntity
import com.ab.dev.shoesly.data.source.local.db.dao.ColorDao

class ColorLocalDataSourceImpl(
    private val colorDao: ColorDao
) : ColorLocalDataSource {

    override suspend fun insertColor(colorEntity: ColorEntity) {
        colorDao.insertColor(colorEntity)
    }

    override suspend fun insertColorsList(colorEntityList: List<ColorEntity>) {
        colorDao.insertColorsList(colorEntityList)
    }

    override fun listColors(): List<ColorEntity> {
        return colorDao.listColors()
    }

    override suspend fun getColorEntityById(colorId: Int): ColorEntity {
        return colorDao.getColorEntityById(colorId)
    }


    override fun listColorsEntityIdByStockItemId(stockItemId: Int): List<Int> {
        return colorDao.listColorsEntityIdByStockItemId(stockItemId)
    }

    override suspend fun listColorsEntityByStockItemId(stockItemId: Int): List<ColorEntity> {
        val colorsEntityIds = listColorsEntityIdByStockItemId(stockItemId)
        return colorsEntityIds.map { id ->
            getColorEntityById(id)
        }
    }

    override suspend fun insertColorStockItemEntity(colorStockItemEntity: ColorStockItemEntity) {
        colorDao.insertColorStockItemEntity(colorStockItemEntity)
    }

    override suspend fun insertColorStockItemEntityList(colorStockItemEntityList: List<ColorStockItemEntity>) {
        colorDao.insertColorStockItemEntityList(colorStockItemEntityList)
    }



}