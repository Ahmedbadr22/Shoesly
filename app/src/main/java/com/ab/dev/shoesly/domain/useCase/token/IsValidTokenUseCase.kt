package com.ab.dev.shoesly.domain.useCase.token

import com.ab.dev.shoesly.domain.repository.token.TokenRepository

class IsValidTokenUseCase(
    private val tokenRepository: TokenRepository
) {

    suspend operator fun invoke(): Boolean {
        return tokenRepository.isValidToken()
    }

}