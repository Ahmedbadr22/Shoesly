package com.ab.dev.shoesly.data.source.remote.dataSource.brand

import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.app.utils.safeApiCall
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.BrandResponse
import com.ab.dev.shoesly.data.source.remote.clientApi.brand.BrandClientApi

class BrandRemoteDataSourceImpl(
    private val brandClientApi: BrandClientApi
) : BrandRemoteDataSource {

    override suspend fun listBrands(accessToken: String) : NetworkResult<List<BrandResponse>, DetailError> = safeApiCall{
        brandClientApi.listBrands(accessToken)
    }
}