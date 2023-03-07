package com.ab.dev.shoesly.domain.repository.brand

import com.ab.dev.shoesly.data.model.entities.brand.BrandEntity
import com.ab.dev.shoesly.domain.models.data.Brand
import com.ab.dev.shoesly.domain.models.data.Token
import kotlinx.coroutines.flow.Flow

interface BrandRepository {
    val brandsListFlow: Flow<List<Brand>>

    suspend fun listBrandsApi(token: Token)
    suspend fun getBrandEntityById(brandId: Int) : BrandEntity
}