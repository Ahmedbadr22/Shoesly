package com.ab.dev.shoesly.data.source.remote.dataSource.registration

import com.ab.dev.shoesly.data.model.request.RegistrationRequest
import com.ab.dev.shoesly.data.source.remote.clientApi.registration.RegistrationClientApi

class RegistrationDataSourceImpl(
    private val registrationClientApi: RegistrationClientApi
) : RegistrationDataSource {

    override suspend fun registrationWithEmail(registrationRequest: RegistrationRequest)  {
        val response = registrationClientApi.registrationWithEmail(registrationRequest)
//        if (response.code() != 201 && !response.isSuccessful) {
//            handleNetworkCallExceptionIfExist<RegistrationErrorBody, Unit>(response)
//        }
    }
}