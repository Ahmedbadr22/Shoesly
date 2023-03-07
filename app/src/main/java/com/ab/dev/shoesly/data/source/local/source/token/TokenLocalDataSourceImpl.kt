package com.ab.dev.shoesly.data.source.local.source.token

import com.ab.dev.shoesly.app.constants.APP.ACCESS_TOKEN
import com.ab.dev.shoesly.app.constants.APP.REFRESH_TOKEN
import com.ab.dev.shoesly.app.constants.APP.REMEMBER_ME
import com.ab.dev.shoesly.app.utils.SharedPreferencesHelper
import com.ab.dev.shoesly.domain.models.data.Token

class TokenLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : TokenLocalDataSource {

    override fun setTokens(token: Token) {
        sharedPreferencesHelper.addString(ACCESS_TOKEN, token.access)
        sharedPreferencesHelper.addString(REFRESH_TOKEN, token.refresh)
    }

    override fun getTokens(): Token? {
        val access = sharedPreferencesHelper.getString(ACCESS_TOKEN)
        val refresh = sharedPreferencesHelper.getString(REFRESH_TOKEN)

        return if (access.isNullOrEmpty() || refresh.isNullOrEmpty()) null
        else Token(access, refresh)

    }

    override fun removeTokens() {
        sharedPreferencesHelper.removeString(ACCESS_TOKEN)
        sharedPreferencesHelper.removeString(REFRESH_TOKEN)
    }

    override fun setRememberMe(rememberMe: Boolean) {
        sharedPreferencesHelper.addBoolean(REMEMBER_ME, rememberMe)
    }

    override fun getIsRememberMe(): Boolean = sharedPreferencesHelper.getBoolean(REMEMBER_ME)
}