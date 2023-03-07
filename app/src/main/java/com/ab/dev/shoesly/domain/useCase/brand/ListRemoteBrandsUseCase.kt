package com.ab.dev.shoesly.domain.useCase.brand

import com.ab.dev.shoesly.domain.models.data.Token
import com.ab.dev.shoesly.domain.repository.brand.BrandRepository
import com.ab.dev.shoesly.domain.repository.token.TokenRepository

class ListRemoteBrandsUseCase(
    private val brandRepository: BrandRepository,
    private val tokenRepository: TokenRepository,
) {
    suspend operator fun invoke() {
        val token : Token? = tokenRepository.getTokenFromSharedPreferences()
        token?.let {
            brandRepository.listBrandsApi(token)
        }
    }
}