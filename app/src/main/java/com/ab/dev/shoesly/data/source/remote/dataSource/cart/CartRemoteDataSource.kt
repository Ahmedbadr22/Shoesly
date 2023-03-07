package com.ab.dev.shoesly.data.source.remote.dataSource.cart

import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.CartItemResponse

interface CartRemoteDataSource {

    suspend fun listUserCartItems(accessToken: String) : NetworkResult<List<CartItemResponse>, DetailError>
}