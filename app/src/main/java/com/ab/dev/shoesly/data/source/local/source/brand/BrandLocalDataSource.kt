package com.ab.dev.shoesly.data.source.local.source.brand

import com.ab.dev.shoesly.data.model.entities.brand.BrandEntity
import kotlinx.coroutines.flow.Flow

interface BrandLocalDataSource {

    suspend fun getBrandById(id: Int) : BrandEntity
    suspend fun addBrand(brandEntity: BrandEntity)

    suspend fun addBrands(brands: List<BrandEntity>)

    fun listBrandsFlow() : Flow<List<BrandEntity>>
}