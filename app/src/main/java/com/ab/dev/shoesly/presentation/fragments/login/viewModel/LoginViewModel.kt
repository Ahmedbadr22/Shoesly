package com.ab.dev.shoesly.presentation.fragments.login.viewModel

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.response.error.LoginResponseErrorBody
import com.ab.dev.shoesly.data.model.response.success.TokenResponse
import com.ab.dev.shoesly.domain.models.form.LoginForm
import com.ab.dev.shoesly.domain.models.state.LoginUiState
import com.ab.dev.shoesly.domain.useCase.login.EmailLoginUseCase
import com.ab.dev.shoesly.domain.useCase.login.SetRememberMeUseCase
import com.ab.dev.shoesly.domain.useCase.login.SignInWithGoogleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val emailLoginUseCase: EmailLoginUseCase,
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase,
    private val setRememberMeUseCase: SetRememberMeUseCase,
) : ViewModel() {
    val uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())

    val loginForm = LoginForm()

    fun login() {
        viewModelScope.launch {
            uiState.update { currentUiState -> currentUiState.copy(isLoading = true) }
            emailLoginUseCase(loginForm).collectLatest { result: NetworkResult<TokenResponse, LoginResponseErrorBody> ->
                when(result) {
                    is NetworkResult.Success -> uiState.update { currentState -> currentState.copy(isUserLoggedIn = true) }
                    is NetworkResult.Error -> {
                        uiState.update { currentState ->
                            currentState.copy(
                                mainUserMessage = result.message,
                                emailErrorMessage = result.error?.emailError,
                                passwordErrorMessage = result.error?.passwordError
                            )
                        }
                    }
                }
            }
            uiState.update { currentUiState -> currentUiState.copy(isLoading = false) }
        }
    }


    fun clearErrors() {
        uiState.update { currentLoginUiState ->
            currentLoginUiState.copy(
                mainUserMessage = null,
            )
        }
    }

    fun loginWithGoogleAccount(intent: Intent) {
        viewModelScope.launch {
            signInWithGoogleUseCase(intent)
        }
    }

    fun setOnRememberMeChanged(rememberMe: Boolean) {
        setRememberMeUseCase(rememberMe)
    }
}