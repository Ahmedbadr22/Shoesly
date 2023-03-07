package com.ab.dev.shoesly.data.repository.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ab.dev.shoesly.app.mappers.asCartItem
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.data.model.response.success.CartItemResponse
import com.ab.dev.shoesly.data.source.remote.dataSource.cart.CartRemoteDataSource
import com.ab.dev.shoesly.domain.models.data.CartItem
import com.ab.dev.shoesly.domain.repository.cart.CartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartRepositoryImpl(
    private val cartRemoteDataSource: CartRemoteDataSource,

) : CartRepository {
    private val _cartItemsLiveData: MutableLiveData<NetworkResult<List<CartItem>, DetailError>> = MutableLiveData()
    override val cartItemsLiveData: LiveData<NetworkResult<List<CartItem>, DetailError>>
        get() = _cartItemsLiveData

    override suspend fun listCartItems(accessToken: String) = withContext(Dispatchers.IO) {
        val result = cartRemoteDataSource.listUserCartItems(accessToken)
        if (result is NetworkResult.Success) {
            val itemsResponse = result.data ?: emptyList()
            val cartItems = itemsResponse.map(CartItemResponse::asCartItem)
            _cartItemsLiveData.postValue(NetworkResult.Success(cartItems))
        } else {
            _cartItemsLiveData.postValue(NetworkResult.Error(error = result.error, message = result.message))
        }
    }


}