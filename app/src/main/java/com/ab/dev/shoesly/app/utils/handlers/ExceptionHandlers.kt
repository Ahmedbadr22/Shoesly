package com.ab.dev.shoesly.app.utils.handlers

import com.ab.dev.shoesly.R
import com.ab.dev.shoesly.app.utils.exceptions.BadRequestException
import com.ab.dev.shoesly.app.utils.exceptions.UnAuthorizedUserException
import com.ab.dev.shoesly.app.utils.parser.JsonParser
import retrofit2.Response

inline fun <reified E,  T>handleNetworkCallExceptionIfExist(response: Response<T>) {
    if (!response.isSuccessful) {
        if (response.code() == 401) throw UnAuthorizedUserException(R.string.un_authorized)
        else if (response.code() == 400) {
            val error = response.errorBody() ?: throw IllegalArgumentException()
            val errorResponse = JsonParser.toResponseError<E>(error.source()) ?: throw IllegalAccessException()
            throw BadRequestException(errorResponse)
        }
    }
}

