package com.ab.dev.shoesly.data.source.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ab.dev.shoesly.app.constants.DB
import com.ab.dev.shoesly.data.model.entities.color.ColorEntity
import com.ab.dev.shoesly.data.model.entities.color.ColorStockItemEntity

@Dao
interface ColorDao {
    /**
     * insert colorEntity instance of [ColorEntity] Table into the DB [DB.COLORS_ENTITY]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColor(colorEntity: ColorEntity)

    /**
     * insert colorEntityList a [List] collection of [ColorEntity] Table into the DB [DB.COLORS_ENTITY]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColorsList(colorEntity: List<ColorEntity>)

    /**
     * @return [List] collection of [ColorEntity] Table
     */
    @Query("SELECT * FROM ${DB.COLORS_ENTITY}")
    fun listColors() : List<ColorEntity>

    /**
     * @return colorEntity instance of [ColorEntity] Table
     * @param [colorId] int color in
     */
    @Query("SELECT * FROM ${DB.COLORS_ENTITY} WHERE id=:colorId")
    suspend fun getColorEntityById(colorId: Int) : ColorEntity

    // Stock Item
    /**
     * @param colorStockItemEntity insert it into the DB [DB.COLORS_STOCK_ITEM_ENTITY]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColorStockItemEntity(colorStockItemEntity: ColorStockItemEntity)

    /**
     * @param colorStockItemEntityList
     * insert [List] collection of [ColorStockItemEntity] into the DB [DB.COLORS_STOCK_ITEM_ENTITY]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColorStockItemEntityList(colorStockItemEntityList: List<ColorStockItemEntity>)

    /**
     * @param [stockItemId] stock item int id
     * @return [List] collection of int id of the colorEntity from the [DB.COLORS_STOCK_ITEM_ENTITY]
     */
    @Query("SELECT colorId FROM ${DB.COLORS_STOCK_ITEM_ENTITY} WHERE stockItemId=:stockItemId")
    fun listColorsEntityIdByStockItemId(stockItemId: Int) : List<Int>
}