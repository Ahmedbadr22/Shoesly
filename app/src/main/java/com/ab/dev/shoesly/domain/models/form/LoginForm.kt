package com.ab.dev.shoesly.domain.models.form

import com.ab.dev.shoesly.data.model.request.LoginRequest

data class LoginForm(
    var email: String = "",
    var password: String = "",
) {
    fun toLoginRequest() : LoginRequest {
        return LoginRequest(email, password)
    }

    val isEmptyEmail : Boolean
        get() = email.isEmpty()

    val isEmptyPassword : Boolean
        get() = password.isEmpty()
}
