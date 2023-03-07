package com.ab.dev.shoesly.data.model.entities.shoe

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.ab.dev.shoesly.app.constants.DB
import com.ab.dev.shoesly.data.model.entities.brand.BrandEntity
import com.ab.dev.shoesly.data.model.entities.review.ReviewEntity

@Entity(tableName = DB.SHOES_ENTITY)
data class ShoeEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val price: Float,
    val brandId: Int,
)

/**
 * This is the relational table between [ShoeEntity], [BrandEntity] and [ReviewEntity]
 * one to one relation between the [ShoeEntity] & [BrandEntity]
 * one to many between the [ShoeEntity] & [ReviewEntity]
 */
data class ShoeWithBrandAndReviews(
    @Embedded val shoeEntity: ShoeEntity,
    @Relation(
        parentColumn = "brandId",
        entityColumn = "id"
    )
    val brandEntity: BrandEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "relatedProductId"
    )
    val reviews: List<ReviewEntity>
)