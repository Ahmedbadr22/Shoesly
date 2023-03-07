package com.ab.dev.shoesly.data.repository.token

import com.ab.dev.shoesly.data.source.local.source.token.TokenLocalDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.token.TokenRemoteDataSource
import com.ab.dev.shoesly.domain.models.data.Token
import com.ab.dev.shoesly.domain.repository.token.TokenRepository

class TokenRepositoryImpl(
    private val tokenRemoteDataSource: TokenRemoteDataSource,
    private val tokenDataSource: TokenLocalDataSource
) : TokenRepository {

    override suspend fun isValidToken(): Boolean {
        val tokens = tokenDataSource.getTokens()
        return tokens != null
    }

    override fun getTokenFromSharedPreferences(): Token? {
        return tokenDataSource.getTokens()
    }

    override fun saveToken(token: Token) {
        tokenDataSource.setTokens(token)
    }

}