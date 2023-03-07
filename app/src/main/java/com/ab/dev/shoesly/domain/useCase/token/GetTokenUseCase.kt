package com.ab.dev.shoesly.domain.useCase.token

import com.ab.dev.shoesly.domain.models.data.Token
import com.ab.dev.shoesly.domain.repository.token.TokenRepository
import com.ab.dev.shoesly.domain.useCase.base.BaseUseCase

class GetTokenUseCase(
    private val tokenRepository: TokenRepository
)  {

    operator fun invoke(): Token? = tokenRepository.getTokenFromSharedPreferences()

}