package com.ab.dev.shoesly.app.di

import com.ab.dev.shoesly.data.source.remote.clientApi.brand.BrandClientApi
import com.ab.dev.shoesly.data.source.remote.clientApi.cart.CartClientApi
import com.ab.dev.shoesly.data.source.remote.clientApi.color.ColorClientApi
import com.ab.dev.shoesly.data.source.remote.clientApi.login.LoginClientApi
import com.ab.dev.shoesly.data.source.remote.clientApi.registration.RegistrationClientApi
import com.ab.dev.shoesly.data.source.remote.clientApi.size.SizeClientApi
import com.ab.dev.shoesly.data.source.remote.clientApi.stock.StockClientApi
import com.ab.dev.shoesly.data.source.remote.clientApi.token.TokenClientApi
import org.koin.dsl.module
import retrofit2.Retrofit

val clientApiModule = module {
    single {
        get<Retrofit>().create(LoginClientApi::class.java)
    }

    single {
        get<Retrofit>().create(RegistrationClientApi::class.java)
    }

    single {
        get<Retrofit>().create(TokenClientApi::class.java)
    }
    single {
        get<Retrofit>().create(BrandClientApi::class.java)
    }

    single {
        get<Retrofit>().create(StockClientApi::class.java)
    }

    single {
        get<Retrofit>().create(CartClientApi::class.java)
    }

    single {
        get<Retrofit>().create(ColorClientApi::class.java)
    }

    single {
        get<Retrofit>().create(SizeClientApi::class.java)
    }
}