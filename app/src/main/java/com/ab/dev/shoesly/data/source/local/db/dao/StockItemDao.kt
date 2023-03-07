package com.ab.dev.shoesly.data.source.local.db.dao

import androidx.room.*
import com.ab.dev.shoesly.app.constants.DB
import com.ab.dev.shoesly.data.model.entities.stock_item.StockItemEntity
import com.ab.dev.shoesly.data.model.entities.stock_item.StockItemWithShoeAndColorsAndSizes
import kotlinx.coroutines.flow.Flow

@Dao
interface StockItemDao {
    /**
     * insert [stockItemEntity] instance Of [StockItemEntity]
     * in [DB.STOCK_ITEMS_ENTITY] Table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStockItem(stockItemEntity: StockItemEntity)

    /**
     * insert [items] [List] Of [StockItemEntity]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStockItems(items: List<StockItemEntity>)

    @Transaction
    @Query("Select * from ${DB.STOCK_ITEMS_ENTITY}")
    fun listStockItemsFlow() : Flow<List<StockItemWithShoeAndColorsAndSizes>>

    @Transaction
    @Query(
        "SELECT ${DB.STOCK_ITEMS_ENTITY}.*\n" +
        "FROM ${DB.STOCK_ITEMS_ENTITY}\n" +
        "INNER JOIN\n" +
        "shoes ON ${DB.SHOES_ENTITY}.id = ${DB.STOCK_ITEMS_ENTITY}.shoeId\n" +
        "WHERE (${DB.SHOES_ENTITY}.brandId = :brandId)"
    )
    fun listStockItemsByBrandIdFlow(brandId: Int) : List<StockItemWithShoeAndColorsAndSizes>
}