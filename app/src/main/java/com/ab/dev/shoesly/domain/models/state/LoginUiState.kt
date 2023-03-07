package com.ab.dev.shoesly.domain.models.state

data class LoginUiState(
    val isLoading : Boolean = false,
    val isUserLoggedIn : Boolean = false,
    val mainUserMessage: String? = null,
    val emailErrorMessage: String? = null,
    val passwordErrorMessage: String? = null
)
