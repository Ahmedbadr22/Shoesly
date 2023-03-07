package com.ab.dev.shoesly.data.source.remote.clientApi.cart

import com.ab.dev.shoesly.app.constants.API
import com.ab.dev.shoesly.data.model.response.success.CartItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CartClientApi {

    @GET(API.LIST_USER_CART_ITEMS_URL)
    suspend fun listUserCartItems(@Header(API.AUTHORIZATION_HEADER) access: String) : Response<List<CartItemResponse>>
}