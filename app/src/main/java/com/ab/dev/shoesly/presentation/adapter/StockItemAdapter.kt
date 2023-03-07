package com.ab.dev.shoesly.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.app.utils.callback.DiffCallback
import com.ab.dev.shoesly.databinding.ShoeItemBinding
import com.ab.dev.shoesly.domain.models.data.StockItem

class StockItemAdapter(private val stockItemClickListener: AdapterClickListener<StockItem>) : ListAdapter<StockItem, StockItemAdapter.StockItemViewHolder>(
    DiffCallback<StockItem>()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockItemViewHolder {
        return StockItemViewHolder.form(parent)
    }

    override fun onBindViewHolder(holder: StockItemViewHolder, position: Int) {
        val stockItem = getItem(position)
        holder.bind(stockItemClickListener, stockItem)
    }

    class StockItemViewHolder(private val binding: ShoeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: AdapterClickListener<StockItem>, stockItem: StockItem) {
            binding.apply {
                item = stockItem
                clickListener = listener
                executePendingBindings()
            }
        }

        companion object {
            fun form(parent: ViewGroup): StockItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ShoeItemBinding.inflate(layoutInflater, parent, false)
                return StockItemViewHolder(binding)
            }
        }
    }
}