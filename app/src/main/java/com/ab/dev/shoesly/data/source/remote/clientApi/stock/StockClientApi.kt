package com.ab.dev.shoesly.data.source.remote.clientApi.stock

import com.ab.dev.shoesly.app.constants.API.BRAND_ID_FIELD
import com.ab.dev.shoesly.app.constants.API.LIST_SHOE_BY_BRAND_URL
import com.ab.dev.shoesly.data.model.response.success.ShoeResponse
import com.ab.dev.shoesly.data.model.response.success.StockItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StockClientApi {

    @GET(LIST_SHOE_BY_BRAND_URL)
    suspend fun listShoeByBrandId(
        @Path(BRAND_ID_FIELD) brandId: Int,
//        @Header(API.AUTHORIZATION_HEADER) accessToken: String
    ) : Response<List<StockItemResponse>>
}