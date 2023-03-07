package com.ab.dev.shoesly.presentation.fragments.cart.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.app.utils.callback.CartItemQuantityClickListener
import com.ab.dev.shoesly.app.utils.result.NetworkResult
import com.ab.dev.shoesly.databinding.FragmentCartBinding
import com.ab.dev.shoesly.domain.models.data.CartItem
import com.ab.dev.shoesly.presentation.adapter.CartItemsAdapter
import com.ab.dev.shoesly.presentation.fragments.cart.viewModel.CartViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : Fragment(), CartItemQuantityClickListener<CartItem> {
    private lateinit var binding: FragmentCartBinding
    private val viewModel: CartViewModel by viewModel()

    private val cartItemsAdapter: CartItemsAdapter = CartItemsAdapter(AdapterClickListener {

    }, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()

        binding.apply {
            lifecycleOwner = this@CartFragment
            viewModel = this@CartFragment.viewModel
        }

        lifecycleScope.launch {
            viewModel.cartItemsLiveData.collect { result ->
                when(result) {
                    is NetworkResult.Error -> Log.d("CartFragment", "Error: CartFragment")
                    is NetworkResult.Success -> {
                        val items = result.data ?: emptyList()
                        cartItemsAdapter.submitList(items)
                        viewModel.calculateTotalCartItemsPrice(items)
                    }
                }
            }
        }
    }

    private fun initAdapters() {
        binding.apply {
            rcvCartItems.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = cartItemsAdapter
                hasFixedSize()
            }
        }
    }

    // on Cart Item Click minus to decrease the item quantity
    override fun onMinus(item: CartItem) {
        val updatedItem = item.copy(quantity = item.quantity - 1)
        updateCartItemList(updatedItem)
    }

    // on Cart Item Click plus to increase the item quantity
    override fun onPlus(item: CartItem) {
        val updatedItem = item.copy(quantity = item.quantity + 1)
        updateCartItemList(updatedItem)
    }

    private fun updateCartItemList(item: CartItem) {
        val list = cartItemsAdapter.currentList.map { cartItem ->
            if (cartItem.id == item.id) item
            else cartItem
        }
        cartItemsAdapter.submitList(list)
    }
}