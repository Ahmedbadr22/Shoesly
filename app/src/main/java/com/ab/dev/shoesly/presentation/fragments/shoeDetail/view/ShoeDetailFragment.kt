package com.ab.dev.shoesly.presentation.fragments.shoeDetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.databinding.FragmentShoeDetailBinding
import com.ab.dev.shoesly.domain.models.data.Color
import com.ab.dev.shoesly.domain.models.data.Size
import com.ab.dev.shoesly.presentation.adapter.ColorAdapter
import com.ab.dev.shoesly.presentation.adapter.SizeAdapter

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val navArgs: ShoeDetailFragmentArgs by navArgs()

    private lateinit var colors : List<Color>
    private lateinit var sizes : List<Size>

    private lateinit var colorsListAdapter : ColorAdapter
    private lateinit var sizesListAdapter: SizeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colors = navArgs.stockItem.colors
        sizes = navArgs.stockItem.sizes

        colorsListAdapter = ColorAdapter(AdapterClickListener { selectedColor ->
            colors = colors.map { color ->
                color.copy(isChecked = selectedColor.id == color.id)
            }

            colorsListAdapter.submitList(colors)
        })

        sizesListAdapter = SizeAdapter(AdapterClickListener { selectedSize ->
            sizes = sizes.map { size ->
                size.copy(isChecked = size.id == selectedSize.id)
            }

            sizesListAdapter.submitList(sizes)
        })

        colorsListAdapter.submitList(colors)
        sizesListAdapter.submitList(sizes)

        binding.apply {
            item = navArgs.stockItem

            toolBarShoeDetail.setupWithNavController(findNavController())

            rvSizes.apply {
                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
                adapter = sizesListAdapter
            }

            rvColors.apply {
                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
                adapter = colorsListAdapter
            }
        }

    }

}