package com.ab.dev.shoesly.domain.useCase.registration

import android.content.res.Resources
import com.ab.dev.shoesly.R
import com.ab.dev.shoesly.app.utils.exceptions.NotValidDataException
import com.ab.dev.shoesly.data.model.request.RegistrationRequest
import com.ab.dev.shoesly.domain.models.error.RegistrationFormError
import com.ab.dev.shoesly.domain.repository.registration.RegistrationRepository
import com.ab.dev.shoesly.domain.models.form.RegistrationForm
import com.ab.dev.shoesly.domain.useCase.base.BaseInputUseCase
import com.ab.dev.shoesly.domain.useCase.base.BaseUseCase

class RegisterUserEmailUseCase(
    private val registrationRepository: RegistrationRepository,
    private val resources: Resources
) : BaseInputUseCase<RegistrationForm, Unit> {

    override suspend operator fun invoke(input: RegistrationForm) {
        validate(input)
        val registrationRequest : RegistrationRequest = input.toRegistrationRequest()
        registrationRepository.registrationWithEmail(registrationRequest)
    }

    override fun validate(input: RegistrationForm) {
        val registrationFormError = RegistrationFormError()

        if(input.isEmptyFirstName) registrationFormError.firstNameError = resources.getString(R.string.this_field_cant_be_empty)
        if(input.isEmptyLastName) registrationFormError.lastNameError = resources.getString(R.string.this_field_cant_be_empty)
        if(input.isEmptyEmail) registrationFormError.emailError = resources.getString(R.string.this_field_cant_be_empty)
        if(input.isEmptyPassword) registrationFormError.passwordError = resources.getString(R.string.this_field_cant_be_empty)

        if (input.isEmptyEmail || input.isEmptyFirstName || input.isEmptyLastName || input.isEmptyPassword) {
            throw NotValidDataException(registrationFormError)
        }
    }
}