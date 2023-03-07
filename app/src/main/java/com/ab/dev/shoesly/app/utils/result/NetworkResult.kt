package com.ab.dev.shoesly.app.utils.result

sealed class NetworkResult<D, E>(
    val data: D? = null,
    val error: E? = null,
    val message: String? = null,
) {
    class Success<D, E>(data: D) : NetworkResult<D, E>(data)
    class Error<D, E>(error: E? = null, message: String?) : NetworkResult<D, E>(error= error, message = message)
}
