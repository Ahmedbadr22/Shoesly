package com.ab.dev.shoesly.data.model.entities.review

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ab.dev.shoesly.app.constants.DB

@Entity(tableName = DB.REVIEWS_ENTITY)
data class ReviewEntity(
    @PrimaryKey
    val id: Int,
    val body: String,
    val date: String,
    val rate: Float,
    val relatedProductId: Int,
)
