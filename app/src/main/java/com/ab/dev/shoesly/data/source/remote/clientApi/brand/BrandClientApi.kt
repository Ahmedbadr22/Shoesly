package com.ab.dev.shoesly.data.source.remote.clientApi.brand

import com.ab.dev.shoesly.app.constants.API.AUTHORIZATION_HEADER
import com.ab.dev.shoesly.app.constants.API.LIST_CREATE_BRAND_URL
import com.ab.dev.shoesly.data.model.response.success.BrandResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface BrandClientApi {

    @GET(LIST_CREATE_BRAND_URL)
    suspend fun listBrands(@Header(AUTHORIZATION_HEADER) accessToken: String) : Response<List<BrandResponse>>
}