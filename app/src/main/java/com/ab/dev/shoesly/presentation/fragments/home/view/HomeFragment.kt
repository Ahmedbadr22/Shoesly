package com.ab.dev.shoesly.presentation.fragments.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ab.dev.shoesly.app.utils.callback.AdapterClickListener
import com.ab.dev.shoesly.databinding.FragmentHomeBinding
import com.ab.dev.shoesly.domain.models.data.Brand
import com.ab.dev.shoesly.presentation.adapter.BrandsAdapter
import com.ab.dev.shoesly.presentation.fragments.home.viewModel.HomeViewModel
import com.ab.dev.shoesly.presentation.fragments.main.view.MainFragmentDirections
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private var navController: NavController? = null
    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var brandsList: List<Brand>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = parentFragment?.parentFragment?.findNavController()

        val brandsAdapter = BrandsAdapter(AdapterClickListener { brand ->
            navigateToBrandFragment(brand)
        })


        binding.apply {
            fragment = this@HomeFragment
            rvBrands.apply {
                layoutManager = GridLayoutManager(requireContext(), 4)
                adapter = brandsAdapter
            }
        }

        lifecycleScope.launch {
            homeViewModel.brandsListFlow.collect { brands ->
                brandsAdapter.submitList(brands)
                brandsList = brands
            }
        }
    }

    fun navigateToAllBrands() {
        navController?.let { controller ->
            val brandsDirection = MainFragmentDirections.actionMainFragmentToBrandsFragment()
            controller.navigate(brandsDirection)
        }
    }

    private fun navigateToBrandFragment(brand: Brand) {
        navController?.let { controller ->
            val navDirection = MainFragmentDirections.actionMainFragmentToBrandFragment(brand)
            controller.navigate(navDirection)
        }
    }
}