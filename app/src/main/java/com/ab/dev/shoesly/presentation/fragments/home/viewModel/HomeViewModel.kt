package com.ab.dev.shoesly.presentation.fragments.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ab.dev.shoesly.domain.models.data.Brand
import com.ab.dev.shoesly.domain.repository.brand.BrandRepository
import com.ab.dev.shoesly.domain.useCase.brand.ListRemoteBrandsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeViewModel(
    listRemoteBrandsUseCase: ListRemoteBrandsUseCase,
    brandRepository: BrandRepository,
) : ViewModel() {
    val brandsListFlow : Flow<List<Brand>> = brandRepository.brandsListFlow

    init {
        viewModelScope.launch {
            listRemoteBrandsUseCase()
        }
    }
}