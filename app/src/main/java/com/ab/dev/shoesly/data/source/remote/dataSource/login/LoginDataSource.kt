package com.ab.dev.shoesly.data.source.remote.dataSource.login

import android.content.Intent
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.request.LoginRequest
import com.ab.dev.shoesly.data.model.response.error.LoginResponseErrorBody
import com.ab.dev.shoesly.data.model.response.success.TokenResponse
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import retrofit2.Response

interface LoginDataSource {
    suspend fun loginWithEmail(loginRequest: LoginRequest) : NetworkResult<TokenResponse, LoginResponseErrorBody>
    suspend fun googleAccountLogin(authCredential: AuthCredential) : Task<AuthResult>
    suspend fun getSignedInAccountFromIntent(intent: Intent) : Task<GoogleSignInAccount>
}