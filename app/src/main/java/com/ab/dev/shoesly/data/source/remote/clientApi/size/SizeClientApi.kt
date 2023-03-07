package com.ab.dev.shoesly.data.source.remote.clientApi.size

import com.ab.dev.shoesly.app.constants.API
import com.ab.dev.shoesly.data.model.response.success.ColorResponse
import com.ab.dev.shoesly.data.model.response.success.SizeResponse
import retrofit2.Response
import retrofit2.http.GET

interface SizeClientApi {

    @GET(API.LIST_SIZES_URL)
    suspend fun listSizes() : Response<List<SizeResponse>>
}