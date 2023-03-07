package com.ab.dev.shoesly.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.app.utils.callback.DiffCallback
import com.ab.dev.shoesly.databinding.RoundedBrandItemBinding
import com.ab.dev.shoesly.domain.models.data.Brand

class MostPopularBrandsAdapter(private val onBrandClickListener: AdapterClickListener<Brand>) : ListAdapter<Brand, MostPopularBrandsAdapter.BrandViewHolder>(DiffCallback<Brand>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        return BrandViewHolder.form(parent)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(onBrandClickListener, category)
    }

    class BrandViewHolder(private val binding: RoundedBrandItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: AdapterClickListener<Brand>, brandItem: Brand) {
            binding.apply {
                brand = brandItem
                clickListener = listener
                executePendingBindings()
            }
        }

        companion object {
            fun form(parent: ViewGroup): BrandViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RoundedBrandItemBinding.inflate(layoutInflater, parent, false)
                return BrandViewHolder(binding)
            }
        }
    }
}