package com.ab.dev.shoesly.data.model.entities.size

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ab.dev.shoesly.app.constants.DB

@Entity(tableName = DB.SIZES_ENTITY)
data class SizeEntity(
    @PrimaryKey
    val id: Int,
    val size: Int,
)

@Entity(tableName = DB.SIZES_STOCK_ITEM_ENTITY)
data class SizeStockItemEntity(
    @PrimaryKey
    val id: String,
    val sizeId: Int,
    val stockItemId: Int
)