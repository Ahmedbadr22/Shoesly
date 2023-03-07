package com.ab.dev.shoesly.domain.useCase.token

import com.ab.dev.shoesly.domain.models.data.Token
import com.ab.dev.shoesly.domain.repository.token.TokenRepository

class SaveTokenUseCase(
    private val tokenRepository: TokenRepository
) {

    suspend operator fun invoke(token: Token) {
        tokenRepository.saveToken(token)
    }
}