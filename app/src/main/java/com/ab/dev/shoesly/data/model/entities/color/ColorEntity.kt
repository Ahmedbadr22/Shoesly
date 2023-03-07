package com.ab.dev.shoesly.data.model.entities.color

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ab.dev.shoesly.app.constants.DB

@Entity(tableName = DB.COLORS_ENTITY)
data class ColorEntity(
    @PrimaryKey
    val id: Int,
    val color: String,
    val hex: String,
)

@Entity(tableName = DB.COLORS_STOCK_ITEM_ENTITY)
data class ColorStockItemEntity(
    @PrimaryKey
    val id: String,
    val colorId: Int,
    val stockItemId: Int
)