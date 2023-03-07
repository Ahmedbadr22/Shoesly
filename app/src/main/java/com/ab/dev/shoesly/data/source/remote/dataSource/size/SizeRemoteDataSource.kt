package com.ab.dev.shoesly.data.source.remote.dataSource.size

import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.SizeResponse

interface SizeRemoteDataSource {

    suspend fun listSizes() : NetworkResult<List<SizeResponse>, DetailError>
}