package com.ab.dev.shoesly.domain.repository.registration

import com.ab.dev.shoesly.app.utils.data.SingleLiveEvent
import com.ab.dev.shoesly.app.utils.result.CallResult
import com.ab.dev.shoesly.data.model.request.RegistrationRequest

interface RegistrationRepository {
    suspend fun registrationWithEmail(registrationRequest: RegistrationRequest)
}