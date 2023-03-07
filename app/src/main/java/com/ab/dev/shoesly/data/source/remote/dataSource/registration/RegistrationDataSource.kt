package com.ab.dev.shoesly.data.source.remote.dataSource.registration

import com.ab.dev.shoesly.data.model.request.RegistrationRequest

interface RegistrationDataSource {
    suspend fun registrationWithEmail(registrationRequest: RegistrationRequest)
}