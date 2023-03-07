package com.ab.dev.shoesly.data.source.remote.dataSource.token

import com.ab.dev.shoesly.data.model.request.TokenVerifyRequest
import com.ab.dev.shoesly.data.source.remote.clientApi.token.TokenClientApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TokenRemoteDataSourceImpl(
    private val tokenClientApi: TokenClientApi
) : TokenRemoteDataSource {

    override suspend fun isValidToken(tokenVerifyRequest: TokenVerifyRequest): Boolean = withContext(Dispatchers.IO) {
        val response = tokenClientApi.verifyToken(tokenVerifyRequest)
        return@withContext response.isSuccessful
    }
}