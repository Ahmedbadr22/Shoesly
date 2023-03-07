package com.ab.dev.shoesly.presentation.fragments.brands

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.databinding.FragmentBrandsBinding
import com.ab.dev.shoesly.domain.models.data.Brand
import com.ab.dev.shoesly.presentation.adapter.BrandsAdapter
import com.ab.dev.shoesly.presentation.fragments.home.viewModel.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel


class BrandsFragment : Fragment() {
    private lateinit var binding: FragmentBrandsBinding
    private val homeViewModel : HomeViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBrandsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val brandsAdapter = BrandsAdapter(AdapterClickListener { brand ->
            navigateToBrandFragment(brand)
        })

        binding.apply {
            toolBarBrands.setupWithNavController(findNavController())

            rvBrands.apply {
                layoutManager = GridLayoutManager(requireContext(), 4)
                adapter = brandsAdapter
            }
        }

        lifecycleScope.launch {
            homeViewModel.brandsListFlow.collect { brands ->
                brandsAdapter.submitList(brands)
            }
        }
    }

    private fun navigateToBrandFragment(brand: Brand) {
        val navDirection = BrandsFragmentDirections.actionBrandsFragmentToBrandFragment(brand)
        findNavController().navigate(navDirection)
    }

}