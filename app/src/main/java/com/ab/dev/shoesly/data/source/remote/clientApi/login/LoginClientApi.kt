package com.ab.dev.shoesly.data.source.remote.clientApi.login

import com.ab.dev.shoesly.app.constants.API
import com.ab.dev.shoesly.data.model.request.LoginRequest
import com.ab.dev.shoesly.data.model.response.success.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginClientApi {
    @POST(API.LOGIN_URL)
    suspend fun login(@Body loginRequest: LoginRequest) : Response<TokenResponse>
}