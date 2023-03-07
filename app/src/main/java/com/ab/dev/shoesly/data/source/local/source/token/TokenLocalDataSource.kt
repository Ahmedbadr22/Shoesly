package com.ab.dev.shoesly.data.source.local.source.token

import com.ab.dev.shoesly.domain.models.data.Token

interface TokenLocalDataSource {

    fun setTokens(token: Token)

    fun getTokens() : Token?

    fun removeTokens()

    fun setRememberMe(rememberMe: Boolean)
    fun getIsRememberMe(): Boolean
}