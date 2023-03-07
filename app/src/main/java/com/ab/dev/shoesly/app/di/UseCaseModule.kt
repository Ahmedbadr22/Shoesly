package com.ab.dev.shoesly.app.di

import com.ab.dev.shoesly.domain.useCase.brand.ListRemoteBrandsUseCase
import com.ab.dev.shoesly.domain.useCase.cart.ListUserCartItemsUseCase
import com.ab.dev.shoesly.domain.useCase.color.GetColorsFromRemoteAndInsertToDBUseCase
import com.ab.dev.shoesly.domain.useCase.login.*
import com.ab.dev.shoesly.domain.useCase.registration.RegisterUserEmailUseCase
import com.ab.dev.shoesly.domain.useCase.size.GetAllSizesFromRemoteAndInsertInLocalUseCase
import com.ab.dev.shoesly.domain.useCase.stock.ListStockItemsByBrandIdFlowUseCase
import com.ab.dev.shoesly.domain.useCase.token.GetTokenUseCase
import com.ab.dev.shoesly.domain.useCase.token.IsValidTokenUseCase
import com.ab.dev.shoesly.domain.useCase.token.SaveTokenUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    // Auth
    singleOf(::EmailLoginUseCase)
    singleOf(::GetGoogleAccountUseCase)
    singleOf(::SignInWithGoogleUseCase)
    singleOf(::RegisterUserEmailUseCase)
    singleOf(::SetRememberMeUseCase)
    singleOf(::GetIsRememberMeUseCase)

    // Token
    singleOf(::IsValidTokenUseCase)
    singleOf(::GetTokenUseCase)

    // Stock
    singleOf(::ListStockItemsByBrandIdFlowUseCase)
    singleOf(::SaveTokenUseCase)

    // Brand
    singleOf(::ListRemoteBrandsUseCase)
    // Cart
    singleOf(::ListUserCartItemsUseCase)
    // Color
    singleOf(::GetColorsFromRemoteAndInsertToDBUseCase)
    singleOf(::GetAllSizesFromRemoteAndInsertInLocalUseCase)
}