package com.ab.dev.shoesly.data.source.remote.dataSource.cart

import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.app.utils.safeApiCall
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.CartItemResponse
import com.ab.dev.shoesly.data.source.remote.clientApi.cart.CartClientApi

class CartRemoteDataSourceImpl(
    private val cartClientApi: CartClientApi
) : CartRemoteDataSource {

    override suspend fun listUserCartItems(accessToken: String): NetworkResult<List<CartItemResponse>, DetailError> = safeApiCall {
        cartClientApi.listUserCartItems(accessToken)
    }
}