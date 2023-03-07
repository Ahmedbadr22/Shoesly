package com.ab.dev.shoesly.app.di

import com.ab.dev.shoesly.data.repository.brand.BrandRepositoryImpl
import com.ab.dev.shoesly.data.repository.cart.CartRepositoryImpl
import com.ab.dev.shoesly.data.repository.color.ColorRepositoryImpl
import com.ab.dev.shoesly.domain.repository.login.LoginRepository
import com.ab.dev.shoesly.data.repository.login.LoginRepositoryImpl
import com.ab.dev.shoesly.domain.repository.registration.RegistrationRepository
import com.ab.dev.shoesly.data.repository.registration.RegistrationRepositoryImpl
import com.ab.dev.shoesly.data.repository.shoe.ShoeRepositoryImpl
import com.ab.dev.shoesly.data.repository.size.SizeRepositoryImpl
import com.ab.dev.shoesly.data.repository.stock.StockRepositoryImpl
import com.ab.dev.shoesly.data.repository.token.TokenRepositoryImpl
import com.ab.dev.shoesly.domain.repository.brand.BrandRepository
import com.ab.dev.shoesly.domain.repository.cart.CartRepository
import com.ab.dev.shoesly.domain.repository.color.ColorRepository
import com.ab.dev.shoesly.domain.repository.shoe.ShoeRepository
import com.ab.dev.shoesly.domain.repository.size.SizeRepository
import com.ab.dev.shoesly.domain.repository.stock.StockRepository
import com.ab.dev.shoesly.domain.repository.token.TokenRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::LoginRepositoryImpl) { bind<LoginRepository>() }
    singleOf(::RegistrationRepositoryImpl) { bind<RegistrationRepository>() }
    singleOf(::TokenRepositoryImpl) { bind<TokenRepository>() }
    // Brand
    singleOf(::BrandRepositoryImpl) { bind<BrandRepository>() }
    // Stock
    singleOf(::StockRepositoryImpl) { bind<StockRepository>() }
    // Cart
    singleOf(::CartRepositoryImpl) { bind<CartRepository>() }
    singleOf(::ShoeRepositoryImpl) { bind<ShoeRepository>() }
    singleOf(::ColorRepositoryImpl) { bind<ColorRepository>() }
    singleOf(::SizeRepositoryImpl) { bind<SizeRepository>() }
}