package com.ab.dev.shoesly.data.source.remote.clientApi.token

import com.ab.dev.shoesly.app.constants.API.TOKEN_VERIFY_URL
import com.ab.dev.shoesly.data.model.request.TokenVerifyRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenClientApi {

    @POST(TOKEN_VERIFY_URL)
    suspend fun verifyToken(@Body tokenVerifyRequest: TokenVerifyRequest) : Response<*>
}