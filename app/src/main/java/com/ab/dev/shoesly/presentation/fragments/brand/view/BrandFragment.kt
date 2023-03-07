package com.ab.dev.shoesly.presentation.fragments.brand.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.databinding.FragmentBrandBinding
import com.ab.dev.shoesly.domain.models.data.StockItem
import com.ab.dev.shoesly.presentation.adapter.StockItemAdapter
import com.ab.dev.shoesly.presentation.fragments.brand.viewModel.BrandViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class BrandFragment : Fragment() {
    private lateinit var binding: FragmentBrandBinding
    private val navArgs: BrandFragmentArgs by navArgs()

    private val brandViewModel: BrandViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBrandBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        brandViewModel.listStockItemsByBrandId(navArgs.brand.id)

        val stockAdapter = StockItemAdapter(AdapterClickListener { stockItem ->
            showStockItemDetailFragment(stockItem)
        })

        binding.apply {
            toolBarBrand.apply {
                title = navArgs.brand.name
                setupWithNavController(findNavController())
            }

            rvShoes.apply {
                layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
                adapter = stockAdapter
            }
        }

        brandViewModel.listedStockItems.observe(viewLifecycleOwner) { shoeItems ->
            stockAdapter.submitList(shoeItems)
            showLoading(false)
        }
    }


    private fun showStockItemDetailFragment(stockItem: StockItem) {
        val navDirection = BrandFragmentDirections.actionBrandFragmentToShoeDetailFragment(stockItem)
        findNavController().navigate(navDirection)
    }

    private fun showLoading(show: Boolean) {
        binding.apply {
            pbLoading.visibility = if (show) View.VISIBLE
            else View.GONE
        }
    }

}