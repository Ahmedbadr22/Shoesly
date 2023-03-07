package com.ab.dev.shoesly.data.source.remote.dataSource.token

import com.ab.dev.shoesly.data.model.request.TokenVerifyRequest
import com.ab.dev.shoesly.domain.models.data.Token


interface TokenRemoteDataSource {
    suspend fun isValidToken(tokenVerifyRequest: TokenVerifyRequest) : Boolean
}