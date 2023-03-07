package com.ab.dev.shoesly.data.repository.login

import android.content.Intent
import android.util.Log
import com.ab.dev.shoesly.app.utils.result.CallResult
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.request.LoginRequest
import com.ab.dev.shoesly.data.model.response.error.LoginResponseErrorBody
import com.ab.dev.shoesly.data.model.response.success.TokenResponse
import com.ab.dev.shoesly.data.source.local.source.token.TokenLocalDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.login.LoginDataSource
import com.ab.dev.shoesly.domain.repository.login.LoginRepository
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthCredential
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class LoginRepositoryImpl(
    private val loginDataSource: LoginDataSource,
    private val tokenDataSource: TokenLocalDataSource
) : LoginRepository {

    override suspend fun loginWithEmail(loginRequest: LoginRequest): NetworkResult<TokenResponse, LoginResponseErrorBody> {
        return loginDataSource.loginWithEmail(loginRequest)
    }

    override suspend fun getSignedInAccount(intent: Intent): CallResult<GoogleSignInAccount> {
        return try {
            val account = loginDataSource.getSignedInAccountFromIntent(intent).await()
            CallResult.Success(account)
        } catch (exception: Exception) {
            CallResult.Error(exception)
        }
    }


    override suspend fun loginWithGoogleAccount(authCredential: AuthCredential): Unit =
        withContext(Dispatchers.IO) {
            try {
                val authResult = loginDataSource.googleAccountLogin(authCredential).await()
                authResult.additionalUserInfo?.let { userInfo ->
                    if (userInfo.isNewUser) {

                    } else {
                        authResult.user?.let { user ->
                            if (user.email == null) return@withContext
                            val loginRequest = LoginRequest(user.email!!, user.uid)
                            loginWithEmail(loginRequest)
                        }
                    }
                }

            } catch (exception: Exception) {
                Log.d("LoginRepository", "$exception")
            }
        }

    override fun setRememberMe(rememberMe: Boolean) {
        tokenDataSource.setRememberMe(rememberMe)
    }

    override fun getIsRememberMe(): Boolean {
        return tokenDataSource.getIsRememberMe()
    }
}