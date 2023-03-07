package com.ab.dev.shoesly.app.di

import com.ab.dev.shoesly.data.source.local.source.brand.BrandLocalDataSource
import com.ab.dev.shoesly.data.source.local.source.brand.BrandLocalDataSourceImpl
import com.ab.dev.shoesly.data.source.local.source.color.ColorLocalDataSource
import com.ab.dev.shoesly.data.source.local.source.color.ColorLocalDataSourceImpl
import com.ab.dev.shoesly.data.source.local.source.shoe.ShoeLocalDataSource
import com.ab.dev.shoesly.data.source.local.source.shoe.ShoeLocalDataSourceImpl
import com.ab.dev.shoesly.data.source.local.source.size.SizeLocalDataSource
import com.ab.dev.shoesly.data.source.local.source.size.SizeLocalDataSourceImpl
import com.ab.dev.shoesly.data.source.local.source.stockItems.StockItemLocalDataSourceImpl
import com.ab.dev.shoesly.data.source.local.source.stockItems.StockItemsLocalDataSource
import com.ab.dev.shoesly.data.source.local.source.token.TokenLocalDataSource
import com.ab.dev.shoesly.data.source.local.source.token.TokenLocalDataSourceImpl
import com.ab.dev.shoesly.data.source.remote.dataSource.brand.BrandRemoteDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.brand.BrandRemoteDataSourceImpl
import com.ab.dev.shoesly.data.source.remote.dataSource.cart.CartRemoteDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.cart.CartRemoteDataSourceImpl
import com.ab.dev.shoesly.data.source.remote.dataSource.color.ColorRemoteDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.color.ColorRemoteDataSourceImpl
import com.ab.dev.shoesly.data.source.remote.dataSource.login.LoginDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.login.LoginDataSourceImpl
import com.ab.dev.shoesly.data.source.remote.dataSource.registration.RegistrationDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.registration.RegistrationDataSourceImpl
import com.ab.dev.shoesly.data.source.remote.dataSource.size.SizeRemoteDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.size.SizeRemoteDataSourceImpl
import com.ab.dev.shoesly.data.source.remote.dataSource.stock.StockRemoteDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.stock.StockRemoteDataSourceImpl
import com.ab.dev.shoesly.data.source.remote.dataSource.token.TokenRemoteDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.token.TokenRemoteDataSourceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataSourceModule = module {
    // remote
    singleOf(::LoginDataSourceImpl) { bind<LoginDataSource>() }
    singleOf(::RegistrationDataSourceImpl) { bind<RegistrationDataSource>() }

    // Token
    singleOf(::TokenLocalDataSourceImpl) { bind<TokenLocalDataSource>() }
    singleOf(::TokenRemoteDataSourceImpl) { bind<TokenRemoteDataSource>() }

    // Brand
    singleOf(::BrandRemoteDataSourceImpl) { bind<BrandRemoteDataSource>() }
    singleOf(::BrandLocalDataSourceImpl) { bind<BrandLocalDataSource>() }

    // Color
    singleOf(::ColorRemoteDataSourceImpl) { bind<ColorRemoteDataSource>() }
    singleOf(::ColorLocalDataSourceImpl) { bind<ColorLocalDataSource>() }

    // Size
    singleOf(::SizeRemoteDataSourceImpl) { bind<SizeRemoteDataSource>() }
    singleOf(::SizeLocalDataSourceImpl) { bind<SizeLocalDataSource>() }

    // Stock
    singleOf(::StockRemoteDataSourceImpl) { bind<StockRemoteDataSource>() }
    singleOf(::StockItemLocalDataSourceImpl) { bind<StockItemsLocalDataSource>() }

    // Cart
    singleOf(::CartRemoteDataSourceImpl) { bind<CartRemoteDataSource>() }

    // Shoe
    singleOf(::ShoeLocalDataSourceImpl) { bind<ShoeLocalDataSource>() }

}