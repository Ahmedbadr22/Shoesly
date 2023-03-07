package com.ab.dev.shoesly.domain.models.error

data class LoginFormError(
    var emailError: String? = null,
    var passwordError: String? = null,
)
