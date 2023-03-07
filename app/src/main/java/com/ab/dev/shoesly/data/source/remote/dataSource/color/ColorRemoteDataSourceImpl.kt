package com.ab.dev.shoesly.data.source.remote.dataSource.color

import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.app.utils.safeApiCall
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.ColorResponse
import com.ab.dev.shoesly.data.source.remote.clientApi.color.ColorClientApi

class ColorRemoteDataSourceImpl(
    private val colorClientApi: ColorClientApi
) : ColorRemoteDataSource {

    override suspend fun listColors(): NetworkResult<List<ColorResponse>, DetailError> = safeApiCall {
        colorClientApi.listColors()
    }
}