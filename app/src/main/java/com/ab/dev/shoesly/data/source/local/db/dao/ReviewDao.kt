package com.ab.dev.shoesly.data.source.local.db.dao

import androidx.room.*
import com.ab.dev.shoesly.app.constants.DB
import com.ab.dev.shoesly.data.model.entities.review.ReviewEntity

@Dao
interface ReviewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReview(reviewEntity: ReviewEntity)

    @Transaction
    @Query("SELECT * FROM ${DB.REVIEWS_ENTITY}")
    suspend fun listReviews() : List<ReviewEntity>
}