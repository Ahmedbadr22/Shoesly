package com.ab.dev.shoesly.domain.models.error

data class RegistrationFormError(
    var firstNameError: String? = null,
    var lastNameError: String? = null,
    var emailError: String? = null,
    var passwordError: String? = null,
)