package com.ab.dev.shoesly.data.model.entities.stock_item

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.ab.dev.shoesly.app.constants.DB
import com.ab.dev.shoesly.data.model.entities.shoe.ShoeEntity

@Entity(tableName = DB.STOCK_ITEMS_ENTITY)
data class StockItemEntity(
    @PrimaryKey
    val id: Int,
    val shoeId: Int,
    val quantityInStock : Int,
)


data class StockItemWithShoeAndColorsAndSizes(
    @Embedded val stockItemEntity: StockItemEntity,
    @Relation(
        parentColumn = "shoeId",
        entityColumn = "id"
    )
    val shoeEntity: ShoeEntity
)



