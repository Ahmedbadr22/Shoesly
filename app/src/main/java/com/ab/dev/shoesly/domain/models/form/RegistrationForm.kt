package com.ab.dev.shoesly.domain.models.form

import com.ab.dev.shoesly.data.model.request.RegistrationRequest

data class RegistrationForm(
    var firstName: String = "",
    var LastName: String = "",
    var email: String = "",
    var password: String = "",
) {
    fun toRegistrationRequest() : RegistrationRequest {
        return RegistrationRequest(firstName, LastName, email, password)
    }

    val isEmptyFirstName : Boolean
        get() = firstName.isEmpty()

    val isEmptyLastName : Boolean
        get() = LastName.isEmpty()

    val isEmptyEmail : Boolean
        get() = email.isEmpty()

    val isEmptyPassword : Boolean
        get() = password.isEmpty()
}