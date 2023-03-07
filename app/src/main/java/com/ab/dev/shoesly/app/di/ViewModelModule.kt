package com.ab.dev.shoesly.app.di

import com.ab.dev.shoesly.presentation.fragments.brand.viewModel.BrandViewModel
import com.ab.dev.shoesly.presentation.fragments.cart.viewModel.CartViewModel
import com.ab.dev.shoesly.presentation.fragments.home.viewModel.HomeViewModel
import com.ab.dev.shoesly.presentation.fragments.login.viewModel.LoginViewModel
import com.ab.dev.shoesly.presentation.fragments.signUp.viewModel.SignUpViewModel
import com.ab.dev.shoesly.presentation.fragments.splash.viewModel.SplashViewModel
import com.ab.dev.shoesly.presentation.mainActivity.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    // Main
    viewModelOf(::MainViewModel)
    // Login
    viewModelOf(::LoginViewModel)
    viewModelOf(::SignUpViewModel)
    viewModelOf(::SplashViewModel)
    viewModelOf(::HomeViewModel)
    // Stock
    viewModelOf(::BrandViewModel)
    // Cart
    viewModelOf(::CartViewModel)

}