package com.ab.dev.shoesly.presentation.fragments.cart.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.data.model.response.error.DetailError
import com.ab.dev.shoesly.domain.models.data.CartItem
import com.ab.dev.shoesly.domain.repository.cart.CartRepository
import com.ab.dev.shoesly.domain.useCase.cart.ListUserCartItemsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CartViewModel(
    private val cartRepository: CartRepository,
    private val listUserCartItemsUseCase: ListUserCartItemsUseCase
) : ViewModel() {

    val cartItemsLiveData: Flow<NetworkResult<List<CartItem>, DetailError>>
        get() = cartRepository.cartItemsLiveData.asFlow()

    val itemsTotalPrice : MutableLiveData<Float> = MutableLiveData(0.0F)

    init {
        viewModelScope.launch {
            listUserCartItemsUseCase()
        }
    }

    fun calculateTotalCartItemsPrice(items: List<CartItem>) {
        var totalPrice = 0.00F
        items.forEach { item -> totalPrice += item.totalPrice }
        itemsTotalPrice.value = totalPrice
    }
}
