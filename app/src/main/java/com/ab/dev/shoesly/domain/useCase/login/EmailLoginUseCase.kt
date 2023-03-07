package com.ab.dev.shoesly.domain.useCase.login

import android.util.Log
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.request.LoginRequest
import com.ab.dev.shoesly.data.model.response.error.LoginResponseErrorBody
import com.ab.dev.shoesly.data.model.response.success.TokenResponse
import com.ab.dev.shoesly.domain.models.data.Token
import com.ab.dev.shoesly.domain.models.form.LoginForm
import com.ab.dev.shoesly.domain.repository.login.LoginRepository
import com.ab.dev.shoesly.domain.useCase.token.SaveTokenUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class EmailLoginUseCase(
    private val loginRepository: LoginRepository,
    private val saveTokenUseCase: SaveTokenUseCase,
    private val isRememberMeUseCase: GetIsRememberMeUseCase
) {

    suspend operator fun invoke(input: LoginForm) : Flow<NetworkResult<TokenResponse, LoginResponseErrorBody>> = flow {
        val loginRequest : LoginRequest = input.toLoginRequest()
        val result = loginRepository.loginWithEmail(loginRequest)
        val isRememberUser : Boolean = isRememberMeUseCase()
        if (isRememberUser) {
            if (result is NetworkResult.Success) {
                result.data?.let { tokenResponse ->
                    val token: Token = tokenResponse.toDomain()
                    Log.d("EmailLoginUseCase", "Token ${token.access}")
                    saveTokenUseCase(token)
                }
            }
        }
        emit(result)
    }.flowOn(Dispatchers.IO)

}