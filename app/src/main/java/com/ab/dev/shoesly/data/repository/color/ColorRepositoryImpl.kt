package com.ab.dev.shoesly.data.repository.color

import com.ab.dev.shoesly.app.mappers.asColorEntity
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.entities.color.ColorEntity
import com.ab.dev.shoesly.data.model.entities.color.ColorStockItemEntity
import com.ab.dev.shoesly.data.model.response.success.ColorResponse
import com.ab.dev.shoesly.data.source.local.source.color.ColorLocalDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.color.ColorRemoteDataSource
import com.ab.dev.shoesly.domain.repository.color.ColorRepository

class ColorRepositoryImpl(
    private val colorRemoteDataSource: ColorRemoteDataSource,
    private val colorLocalDataSource: ColorLocalDataSource
) : ColorRepository {

    override suspend fun getColorsFromRemoteAndInsertToLocalDataSource() {
        val result = colorRemoteDataSource.listColors()
        if (result is NetworkResult.Success) {
            result.data?.let { colorsResponseList ->
                if (colorsResponseList.isNotEmpty()) {
                    val colorsEntityList : List<ColorEntity> = colorsResponseList.map(ColorResponse::asColorEntity)
                    colorLocalDataSource.insertColorsList(colorsEntityList)
                }
            }
        }
    }

    override suspend fun insertColorStockItemEntity(colorStockItemEntity: ColorStockItemEntity) {
        colorLocalDataSource.insertColorStockItemEntity(colorStockItemEntity)
    }

    override suspend fun insertColorStockItemEntityList(colorStockItemEntityList: List<ColorStockItemEntity>) {
        colorLocalDataSource.insertColorStockItemEntityList(colorStockItemEntityList)
    }

    override fun listColorsEntityIdByStockItemId(stockItemId: Int): List<Int> {
        return colorLocalDataSource.listColorsEntityIdByStockItemId(stockItemId)
    }

    override suspend fun listColorsEntityListByStockItemId(stockItemId: Int): List<ColorEntity> {
        val colorsEntityIdList = listColorsEntityIdByStockItemId(stockItemId)
        return colorsEntityIdList.map { id -> colorLocalDataSource.getColorEntityById(id) }
    }


}