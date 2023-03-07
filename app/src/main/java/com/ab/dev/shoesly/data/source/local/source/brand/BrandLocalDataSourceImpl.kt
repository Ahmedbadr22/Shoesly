package com.ab.dev.shoesly.data.source.local.source.brand

import com.ab.dev.shoesly.data.model.entities.brand.BrandEntity
import com.ab.dev.shoesly.data.source.local.db.dao.BrandDao
import kotlinx.coroutines.flow.Flow

class BrandLocalDataSourceImpl(
    private val brandDao: BrandDao,
) : BrandLocalDataSource {

    override suspend fun getBrandById(id: Int) : BrandEntity {
        return brandDao.getBrandById(id)
    }

    override suspend fun addBrand(brandEntity: BrandEntity) {
        brandDao.insertBrand(brandEntity)
    }

    override suspend fun addBrands(brands: List<BrandEntity>) {
        brandDao.insertBrands(brands)
    }

    override fun listBrandsFlow() : Flow<List<BrandEntity>> = brandDao.listBrandsFlow()
}