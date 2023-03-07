package com.ab.dev.shoesly.data.source.remote.clientApi.registration

import com.ab.dev.shoesly.app.constants.API
import com.ab.dev.shoesly.data.model.request.RegistrationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationClientApi {
    @POST(API.REGISTRATION_URL)
    suspend fun registrationWithEmail(@Body registrationRequest: RegistrationRequest) : Response<*>
}