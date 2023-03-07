package com.ab.dev.shoesly.data.repository.registration

import com.ab.dev.shoesly.data.model.request.RegistrationRequest
import com.ab.dev.shoesly.data.source.remote.dataSource.registration.RegistrationDataSource
import com.ab.dev.shoesly.domain.repository.registration.RegistrationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegistrationRepositoryImpl(
    private val registrationDataSource: RegistrationDataSource
) : RegistrationRepository {


    override suspend fun registrationWithEmail(registrationRequest: RegistrationRequest) {
        withContext(Dispatchers.IO) {
            registrationDataSource.registrationWithEmail(registrationRequest)
        }
    }
}