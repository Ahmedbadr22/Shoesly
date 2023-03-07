package com.ab.dev.shoesly.domain.useCase.login

import android.content.Intent
import com.ab.dev.shoesly.domain.repository.login.LoginRepository
import com.google.firebase.auth.GoogleAuthProvider

class SignInWithGoogleUseCase(
    private val getGoogleAccountUseCase: GetGoogleAccountUseCase,
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(intent: Intent) {
        val account = getGoogleAccountUseCase(intent)
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        loginRepository.loginWithGoogleAccount(credential)
    }
}