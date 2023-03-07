package com.ab.dev.shoesly.data.repository.brand

import com.ab.dev.shoesly.app.mappers.asBrand
import com.ab.dev.shoesly.app.mappers.asBrandEntity
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.entities.brand.BrandEntity
import com.ab.dev.shoesly.data.model.response.success.BrandResponse
import com.ab.dev.shoesly.data.source.local.source.brand.BrandLocalDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.brand.BrandRemoteDataSource
import com.ab.dev.shoesly.domain.models.data.Brand
import com.ab.dev.shoesly.domain.models.data.Token
import com.ab.dev.shoesly.domain.repository.brand.BrandRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BrandRepositoryImpl(
    private val brandRemoteDataSource: BrandRemoteDataSource,
    private val brandLocalDataSource: BrandLocalDataSource,
) : BrandRepository {

    override val brandsListFlow: Flow<List<Brand>> =
        brandLocalDataSource.listBrandsFlow()
            .map { brandsEntityList -> brandsEntityList.map(BrandEntity::asBrand) }

    override suspend fun listBrandsApi(token: Token) {
        val result = brandRemoteDataSource.listBrands(token.bearerAccessToken)
        if (result is NetworkResult.Success) {
            result.data?.let { brandsResponse ->
                val brandsList = brandsResponse.map(BrandResponse::asBrand)
                val brandsEntity = brandsList.map(Brand::asBrandEntity)
                brandLocalDataSource.addBrands(brandsEntity)
            }
        }
    }

    override suspend fun getBrandEntityById(brandId: Int): BrandEntity {
        return brandLocalDataSource.getBrandById(brandId)
    }
}