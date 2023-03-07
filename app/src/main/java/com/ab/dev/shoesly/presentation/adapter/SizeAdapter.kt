package com.ab.dev.shoesly.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.app.utils.callback.DiffCallback
import com.ab.dev.shoesly.databinding.SizeItemBinding
import com.ab.dev.shoesly.domain.models.data.Size

class SizeAdapter(private val sizeClickListener: AdapterClickListener<Size>) : ListAdapter<Size, SizeAdapter.SizeViewHolder>(
    DiffCallback<Size>()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeViewHolder {
        return SizeViewHolder.form(parent)
    }

    override fun onBindViewHolder(holder: SizeViewHolder, position: Int) {
        val size = getItem(position)
        holder.bind(sizeClickListener, size)
    }

    class SizeViewHolder(private val binding: SizeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: AdapterClickListener<Size>, sizeItem: Size) {
            binding.apply {
                size = sizeItem
                clickListener = listener
                executePendingBindings()
            }
        }

        companion object {
            fun form(parent: ViewGroup): SizeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SizeItemBinding.inflate(layoutInflater, parent, false)
                return SizeViewHolder(binding)
            }
        }
    }
}