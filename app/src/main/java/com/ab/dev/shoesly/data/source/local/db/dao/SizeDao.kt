package com.ab.dev.shoesly.data.source.local.db.dao

import androidx.room.*
import com.ab.dev.shoesly.app.constants.DB
import com.ab.dev.shoesly.data.model.entities.color.ColorEntity
import com.ab.dev.shoesly.data.model.entities.color.ColorStockItemEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeStockItemEntity

@Dao
interface SizeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSize(sizeEntity: SizeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSizes(sizeEntity: List<SizeEntity>)

    @Query("SELECT * FROM ${DB.SIZES_ENTITY} WHERE id=:sizeId")
    suspend fun getSizeEntityById(sizeId: Int) : SizeEntity


    @Transaction
    @Query("SELECT * FROM ${DB.SIZES_ENTITY}")
    suspend fun listSizes() : List<SizeEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSizeStockItemEntity(sizeStockItemEntity: SizeStockItemEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSizeStockItemEntityList(sizeStockItemEntityList: List<SizeStockItemEntity>)

    @Query("SELECT sizeId FROM ${DB.SIZES_STOCK_ITEM_ENTITY} WHERE stockItemId=:stockItemId")
    fun listSizesIdOfSizeStockItemListByStockItemId(stockItemId: Int) : List<Int>
}