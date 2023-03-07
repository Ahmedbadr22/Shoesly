package com.ab.dev.shoesly.data.source.local.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ab.dev.shoesly.data.model.entities.brand.BrandEntity
import com.ab.dev.shoesly.data.model.entities.color.ColorEntity
import com.ab.dev.shoesly.data.model.entities.color.ColorStockItemEntity
import com.ab.dev.shoesly.data.model.entities.review.ReviewEntity
import com.ab.dev.shoesly.data.model.entities.shoe.ShoeEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeStockItemEntity
import com.ab.dev.shoesly.data.model.entities.stock_item.StockItemEntity
import com.ab.dev.shoesly.data.source.local.db.dao.*

@Database(
    entities = [
        BrandEntity::class,
        ShoeEntity::class,
        ReviewEntity::class,
        SizeEntity::class,
        StockItemEntity::class,
        ColorEntity::class,
        ColorStockItemEntity::class,
        SizeStockItemEntity::class
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getBrandDao(): BrandDao
    abstract fun getShoeDao(): ShoeDao
    abstract fun getReviewDao(): ReviewDao
    abstract fun getSizeDao(): SizeDao
    abstract fun getStockItemDao(): StockItemDao
    abstract fun getColorDao(): ColorDao
}