package com.ab.dev.shoesly.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.app.utils.callback.DiffCallback
import com.ab.dev.shoesly.databinding.ColorItemBinding
import com.ab.dev.shoesly.databinding.SizeItemBinding
import com.ab.dev.shoesly.domain.models.data.Color
import com.ab.dev.shoesly.domain.models.data.Size

class ColorAdapter(private val colorClickListener: AdapterClickListener<Color>) : ListAdapter<Color, ColorAdapter.SizeViewHolder>(
    DiffCallback<Color>()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeViewHolder {
        return SizeViewHolder.form(parent)
    }

    override fun onBindViewHolder(holder: SizeViewHolder, position: Int) {
        val size = getItem(position)
        holder.bind(colorClickListener, size)
    }

    class SizeViewHolder(private val binding: ColorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: AdapterClickListener<Color>, colorItem: Color) {
            binding.apply {
                color = colorItem
                clickListener = listener
                executePendingBindings()
            }
        }

        companion object {
            fun form(parent: ViewGroup): SizeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ColorItemBinding.inflate(layoutInflater, parent, false)
                return SizeViewHolder(binding)
            }
        }
    }
}