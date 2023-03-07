package com.ab.dev.shoesly.domain.repository.token

import com.ab.dev.shoesly.domain.models.data.Token

interface TokenRepository {

    // Get token from shared preferences and validate it from server
    suspend fun isValidToken() : Boolean

    // get Token From SharedPreferences
    fun getTokenFromSharedPreferences() : Token?

    fun saveToken(token: Token)
}