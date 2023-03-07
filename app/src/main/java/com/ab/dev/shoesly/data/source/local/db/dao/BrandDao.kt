package com.ab.dev.shoesly.data.source.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ab.dev.shoesly.app.constants.DB
import com.ab.dev.shoesly.data.model.entities.brand.BrandEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BrandDao {

    @Query("SELECT * FROM ${DB.BRANDS_ENTITY} WHERE id = :id")
    suspend fun getBrandById(id: Int) : BrandEntity

    /**
     * insert [brandEntity] instance Of [BrandEntity]
     * in [DB.BRANDS_ENTITY] Table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBrand(brandEntity: BrandEntity)

    /**
     * insert [List] Of [BrandEntity]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBrands(brands: List<BrandEntity>)

    /**
     * list a [List] Of [BrandEntity] instances
     */
    @Query("SELECT * FROM ${DB.BRANDS_ENTITY}")
    suspend fun listBrands() : List<BrandEntity>


    /**
     * return Flow of [List] Of [BrandEntity] instances
     */
    @Query("SELECT * FROM ${DB.BRANDS_ENTITY}")
    fun listBrandsFlow() : Flow<List<BrandEntity>>
}