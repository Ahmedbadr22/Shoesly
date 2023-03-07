package com.ab.dev.shoesly.data.source.remote.dataSource.size

import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.app.utils.safeApiCall
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.SizeResponse
import com.ab.dev.shoesly.data.source.remote.clientApi.size.SizeClientApi

class SizeRemoteDataSourceImpl(
    private val sizeClientApi: SizeClientApi
) : SizeRemoteDataSource {

    override suspend fun listSizes(): NetworkResult<List<SizeResponse>, DetailError> = safeApiCall {
        sizeClientApi.listSizes()
    }
}