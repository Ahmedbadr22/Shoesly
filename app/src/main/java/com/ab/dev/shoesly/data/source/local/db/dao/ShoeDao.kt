package com.ab.dev.shoesly.data.source.local.db.dao

import androidx.room.*
import com.ab.dev.shoesly.app.constants.DB
import com.ab.dev.shoesly.data.model.entities.shoe.ShoeEntity
import com.ab.dev.shoesly.data.model.entities.shoe.ShoeWithBrandAndReviews

@Dao
interface ShoeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoe(shoeEntity: ShoeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoes(shoeEntity: List<ShoeEntity>)

    @Query("SELECT * FROM ${DB.SHOES_ENTITY} WHERE id = :id")
    suspend fun getShoeById(id: Int) : ShoeEntity

    @Transaction
    @Query("SELECT * FROM ${DB.SHOES_ENTITY} WHERE id = :id")
    suspend fun getShoeWithBrandAndReviewsById(id: Int) : ShoeWithBrandAndReviews

    @Transaction
    @Query("SELECT * FROM ${DB.SHOES_ENTITY}")
    suspend fun listShoes() : List<ShoeWithBrandAndReviews>
}