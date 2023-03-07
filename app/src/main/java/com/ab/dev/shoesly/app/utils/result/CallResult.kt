package com.ab.dev.shoesly.app.utils.result

sealed class CallResult<L>(
    val data: L? = null,
    val error: Exception? = null
) {
    class Success<L>(data: L) : CallResult<L>(data)
    class Error<L>(error: Exception?) : CallResult<L>(error = error)
}
