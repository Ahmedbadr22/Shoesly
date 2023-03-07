package com.ab.dev.shoesly.domain.useCase.login

import android.content.Intent
import com.ab.dev.shoesly.app.utils.result.CallResult
import com.ab.dev.shoesly.domain.repository.login.LoginRepository
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class GetGoogleAccountUseCase(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(intent: Intent) : GoogleSignInAccount {
        val result = loginRepository.getSignedInAccount(intent)
        if (result is CallResult.Error) throw result.error!!
        return result.data!!
    }
}