package com.ab.dev.shoesly.domain.useCase.login

import com.ab.dev.shoesly.domain.repository.login.LoginRepository

class GetIsRememberMeUseCase(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(): Boolean {
        return loginRepository.getIsRememberMe()
    }
}