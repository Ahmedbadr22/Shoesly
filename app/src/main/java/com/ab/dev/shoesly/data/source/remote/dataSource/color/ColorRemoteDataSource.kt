package com.ab.dev.shoesly.data.source.remote.dataSource.color

import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.ColorResponse

interface ColorRemoteDataSource {

    suspend fun listColors() : NetworkResult<List<ColorResponse>, DetailError>
}