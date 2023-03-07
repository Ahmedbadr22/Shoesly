package com.ab.dev.shoesly.data.repository.size

import com.ab.dev.shoesly.app.mappers.asSizeEntity
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.entities.size.SizeEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeStockItemEntity
import com.ab.dev.shoesly.data.model.response.success.SizeResponse
import com.ab.dev.shoesly.data.source.local.source.size.SizeLocalDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.size.SizeRemoteDataSource
import com.ab.dev.shoesly.domain.repository.size.SizeRepository

class SizeRepositoryImpl(
    private val sizeRemoteDataSource: SizeRemoteDataSource,
    private val sizeLocalDataSource: SizeLocalDataSource
) : SizeRepository {

    override suspend fun getSizesFromRemoteAndInsertToLocalDataSource() {
        val result = sizeRemoteDataSource.listSizes()
        if (result is NetworkResult.Success) {
            result.data?.let { sizesResponseList ->
                if (sizesResponseList.isNotEmpty()) {
                    val colorsEntityList : List<SizeEntity> = sizesResponseList.map(SizeResponse::asSizeEntity)
                    sizeLocalDataSource.insertSizesList(colorsEntityList)
                }
            }
        }
    }

    override suspend fun insertSizeStockItemEntity(sizeStockItemEntity: SizeStockItemEntity) {
        sizeLocalDataSource.insertSizeStockItemEntity(sizeStockItemEntity)
    }

    override suspend fun insertSizeStockItemEntityList(sizeStockItemEntityList: List<SizeStockItemEntity>) {
        sizeLocalDataSource.insertSizeStockItemEntityList(sizeStockItemEntityList)
    }

    override fun listSizesEntityIdByStockItemId(stockItemId: Int): List<Int> {
        return sizeLocalDataSource.listSizesIdOfSizeStockItemListByStockItemId(stockItemId)
    }

    override suspend fun listSizesEntityListByStockItemId(stockItemId: Int): List<SizeEntity> {
        val sizesIdsList: List<Int> = listSizesEntityIdByStockItemId(stockItemId)
        return sizesIdsList.map { id ->
            sizeLocalDataSource.getSizeEntityById(id)
        }
    }
}