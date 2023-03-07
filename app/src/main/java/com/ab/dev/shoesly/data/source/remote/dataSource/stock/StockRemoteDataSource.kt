package com.ab.dev.shoesly.data.source.remote.dataSource.stock

import com.ab.dev.shoesly.data.model.response.success.StockItemResponse

interface StockRemoteDataSource {
    suspend fun listShoesByBrandId(brandId: Int) : List<StockItemResponse>
}