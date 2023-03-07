package com.ab.dev.shoesly.presentation.fragments.splash.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ab.dev.shoesly.domain.useCase.login.GetIsRememberMeUseCase
import com.ab.dev.shoesly.domain.useCase.token.IsValidTokenUseCase
import kotlinx.coroutines.launch

class SplashViewModel(
    private val isValidTokenUseCase: IsValidTokenUseCase,
    getIsRememberMeUseCase: GetIsRememberMeUseCase
) : ViewModel() {

    val isRememberMe : Boolean = getIsRememberMeUseCase()
    var isValidToken: Boolean = false

    init {
        validateToken()
    }

    private fun validateToken()  {
        viewModelScope.launch {
            isValidToken = isValidTokenUseCase()
        }
    }

}