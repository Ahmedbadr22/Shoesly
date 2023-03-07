package com.ab.dev.shoesly.data.source.remote.dataSource.login

import android.content.Intent
import com.ab.dev.shoesly.app.utils.handlers.handleNetworkCallExceptionIfExist
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.app.utils.safeApiCall
import com.ab.dev.shoesly.data.model.request.LoginRequest
import com.ab.dev.shoesly.data.model.response.error.LoginResponseErrorBody
import com.ab.dev.shoesly.data.model.response.success.TokenResponse
import com.ab.dev.shoesly.data.source.remote.clientApi.login.LoginClientApi
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class LoginDataSourceImpl(
    private val loginClientApi: LoginClientApi
) : LoginDataSource {

    override suspend fun loginWithEmail(loginRequest: LoginRequest): NetworkResult<TokenResponse, LoginResponseErrorBody> = safeApiCall {
        loginClientApi.login(loginRequest)
    }

    override suspend fun googleAccountLogin(authCredential: AuthCredential): Task<AuthResult> {
        return Firebase.auth.signInWithCredential(authCredential)
    }

    override suspend fun getSignedInAccountFromIntent(intent: Intent): Task<GoogleSignInAccount> {
        return GoogleSignIn.getSignedInAccountFromIntent(intent)
    }

}