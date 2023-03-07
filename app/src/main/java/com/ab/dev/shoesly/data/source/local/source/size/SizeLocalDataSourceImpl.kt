package com.ab.dev.shoesly.data.source.local.source.size

import com.ab.dev.shoesly.data.model.entities.size.SizeEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeStockItemEntity
import com.ab.dev.shoesly.data.source.local.db.dao.SizeDao

class SizeLocalDataSourceImpl(
    private val sizeDao: SizeDao
) : SizeLocalDataSource {

    override suspend fun insertSize(sizeEntity: SizeEntity) {
        sizeDao.insertSize(sizeEntity)
    }

    override suspend fun insertSizesList(sizeEntityList: List<SizeEntity>) {
        sizeDao.insertSizes(sizeEntityList)
    }

    override suspend fun listSizes(): List<SizeEntity> {
        return sizeDao.listSizes()
    }

    override suspend fun getSizeEntityById(sizeId: Int): SizeEntity {
        return sizeDao.getSizeEntityById(sizeId)
    }


    override suspend fun insertSizeStockItemEntity(sizeStockItemEntity: SizeStockItemEntity) {
        sizeDao.insertSizeStockItemEntity(sizeStockItemEntity)
    }

    override suspend fun insertSizeStockItemEntityList(sizeStockItemEntityList: List<SizeStockItemEntity>) {
        sizeDao.insertSizeStockItemEntityList(sizeStockItemEntityList)
    }

    override fun listSizesIdOfSizeStockItemListByStockItemId(stockItemId: Int): List<Int> {
        return sizeDao.listSizesIdOfSizeStockItemListByStockItemId(stockItemId)
    }


}