package com.ab.dev.shoesly.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.app.utils.callback.CartItemQuantityClickListener
import com.ab.dev.shoesly.app.utils.callback.DiffCallback
import com.ab.dev.shoesly.databinding.CartItemBinding
import com.ab.dev.shoesly.domain.models.data.CartItem

class CartItemsAdapter(
    private val brandClickListener: AdapterClickListener<CartItem>,
    private val itemQuantityClickListener: CartItemQuantityClickListener<CartItem>
) : ListAdapter<CartItem, CartItemsAdapter.CartItemViewHolder>(DiffCallback<CartItem>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        return CartItemViewHolder.form(parent)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(brandClickListener, itemQuantityClickListener, category)
    }

    class CartItemViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: AdapterClickListener<CartItem>, itemQuantityClickListener: CartItemQuantityClickListener<CartItem>, cartItem: CartItem) {
            binding.apply {
                item = cartItem
                quantityClickListener = itemQuantityClickListener
                clickListener = listener
                executePendingBindings()
            }
        }

        companion object {
            fun form(parent: ViewGroup): CartItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CartItemBinding.inflate(layoutInflater, parent, false)
                return CartItemViewHolder(binding)
            }
        }
    }
}

abstract class CartObserver {
    lateinit var cartSubject: CartSubject
    abstract fun update()
}

abstract class CartSubject {
    private val observers = mutableListOf<CartObserver>()


    fun addObserver(cartObserver: CartObserver) {
        observers.add(cartObserver)
    }

    fun removeObserver(cartObserver: CartObserver) {
        observers.remove(cartObserver)
    }

    fun notifyCartObservers() {
        observers.forEach { cartObserver ->
            cartObserver.update()
        }
    }
}