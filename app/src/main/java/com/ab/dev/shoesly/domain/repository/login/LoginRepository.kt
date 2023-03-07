package com.ab.dev.shoesly.domain.repository.login

import android.content.Intent
import androidx.lifecycle.LiveData
import com.ab.dev.shoesly.app.utils.data.SingleLiveEvent
import com.ab.dev.shoesly.app.utils.result.CallResult
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.request.LoginRequest
import com.ab.dev.shoesly.data.model.response.error.LoginResponseErrorBody
import com.ab.dev.shoesly.data.model.response.success.TokenResponse
import com.ab.dev.shoesly.domain.models.data.Token
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthCredential
import retrofit2.Response

interface LoginRepository {
    suspend fun loginWithEmail(loginRequest: LoginRequest) : NetworkResult<TokenResponse, LoginResponseErrorBody>
    suspend fun loginWithGoogleAccount(authCredential: AuthCredential)
    suspend fun getSignedInAccount(intent: Intent) : CallResult<GoogleSignInAccount>

    // Remember me
    fun setRememberMe(rememberMe: Boolean)
    fun getIsRememberMe(): Boolean
}