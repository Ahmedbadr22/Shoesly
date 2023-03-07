package com.ab.dev.shoesly.domain.useCase.login

import com.ab.dev.shoesly.domain.repository.login.LoginRepository
import com.ab.dev.shoesly.domain.useCase.base.BaseUseCase

class SetRememberMeUseCase(
    private val loginRepository: LoginRepository
)  {
    operator fun invoke(input: Boolean) {
        loginRepository.setRememberMe(input)
    }
}