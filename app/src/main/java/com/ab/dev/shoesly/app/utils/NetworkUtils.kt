package com.ab.dev.shoesly.app.utils

import android.util.Log
import com.ab.dev.shoesly.app.utils.parser.JsonParser
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.response.error.DetailError
import retrofit2.Response

inline fun <reified T, reified E> safeApiCall(apiCall: () -> Response<T>): NetworkResult<T, E> {
    return try {
        val apiResponse = apiCall.invoke() as Response<*>
        when (apiResponse.code()) {
            in 200..299 -> {
                val data = apiResponse.body() as T
                NetworkResult.Success(data)
            }
            401 -> {
                val error = apiResponse.errorBody()!!
                val errorResponse = JsonParser.toResponseError<DetailError>(error.source())
                NetworkResult.Error(null, errorResponse!!.detail)
            }
            400 -> {
                val error = apiResponse.errorBody()!!
                val errorResponse = JsonParser.toResponseError<E>(error.source())
                NetworkResult.Error(errorResponse, null)
            }
            else -> {
                Log.d("NetworkUtil", "${apiResponse.code()}")
                NetworkResult.Error(null, "Unknown Error")
            }
        }
    } catch (e: Exception){
        Log.d("NetworkUtils", "Error ==> ${e.message} | ${e.localizedMessage} | ${e.cause}")
        NetworkResult.Error(null, e.localizedMessage)
    }
}
