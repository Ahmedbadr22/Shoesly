package com.ab.dev.shoesly.domain.models.data

data class UiState<D, R>(
    val data: D,
    val result: R? = null,
    val isLoading : Boolean = false
)