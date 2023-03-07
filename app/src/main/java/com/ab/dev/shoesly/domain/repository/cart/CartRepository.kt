package com.ab.dev.shoesly.domain.repository.cart

import androidx.lifecycle.LiveData
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.domain.models.data.CartItem

interface CartRepository {
    val cartItemsLiveData: LiveData<NetworkResult<List<CartItem>, DetailError>>


    suspend fun listCartItems(accessToken: String)
}