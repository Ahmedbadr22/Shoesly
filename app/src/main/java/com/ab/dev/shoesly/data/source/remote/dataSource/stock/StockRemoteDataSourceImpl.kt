package com.ab.dev.shoesly.data.source.remote.dataSource.stock

import com.ab.dev.shoesly.app.utils.handlers.handleNetworkCallExceptionIfExist
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.StockItemResponse
import com.ab.dev.shoesly.data.source.remote.clientApi.stock.StockClientApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StockRemoteDataSourceImpl(
    private val stockClientApi: StockClientApi
) : StockRemoteDataSource {

    override suspend fun listShoesByBrandId(brandId: Int): List<StockItemResponse> = withContext(Dispatchers.IO) {
        val response = stockClientApi.listShoeByBrandId(brandId)
        handleNetworkCallExceptionIfExist<DetailError, List<StockItemResponse>>(response)
        return@withContext response.body() ?: emptyList()
    }
}