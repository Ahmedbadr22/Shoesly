package com.ab.dev.shoesly.domain.models.state

data class RegistrationUiState (
    val isLoading : Boolean = false,
    val isSuccessOperation : Boolean = false,
    val firstNameErrorMessage: String? = null,
    val lastNameErrorMessage: String? = null,
    val emailErrorMessage: String? = null,
    val passwordErrorMessage: String? = null,
    var mainUserMessageRes: Int? = null
)