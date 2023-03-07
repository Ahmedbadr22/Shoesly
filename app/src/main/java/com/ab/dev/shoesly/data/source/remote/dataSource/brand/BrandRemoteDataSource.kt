package com.ab.dev.shoesly.data.source.remote.dataSource.brand

import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.BrandResponse

interface BrandRemoteDataSource {
    suspend fun listBrands(accessToken: String) : NetworkResult<List<BrandResponse>, DetailError>
}