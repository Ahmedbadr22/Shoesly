package com.ab.dev.shoesly.data.source.remote.clientApi.color

import com.ab.dev.shoesly.app.constants.API
import com.ab.dev.shoesly.data.model.response.success.ColorResponse
import retrofit2.Response
import retrofit2.http.GET

interface ColorClientApi {

    @GET(API.LIST_COLORS_URL)
    suspend fun listColors() : Response<List<ColorResponse>>
}