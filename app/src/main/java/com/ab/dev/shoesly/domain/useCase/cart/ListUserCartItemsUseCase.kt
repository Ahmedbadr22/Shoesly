package com.ab.dev.shoesly.domain.useCase.cart

import com.ab.dev.shoesly.domain.repository.cart.CartRepository
import com.ab.dev.shoesly.domain.useCase.base.BaseUseCase
import com.ab.dev.shoesly.domain.useCase.token.GetTokenUseCase

class ListUserCartItemsUseCase(
    private val getTokenUseCase: GetTokenUseCase,
    private val cartRepository: CartRepository
) : BaseUseCase<Unit> {

    override suspend fun invoke() {
        val token = getTokenUseCase()
        token?.let {
            cartRepository.listCartItems(token.bearerAccessToken)
        }
    }
}