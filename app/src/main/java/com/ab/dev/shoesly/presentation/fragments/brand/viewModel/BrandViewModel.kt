package com.ab.dev.shoesly.presentation.fragments.brand.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ab.dev.shoesly.domain.models.data.StockItem
import com.ab.dev.shoesly.domain.useCase.stock.ListStockItemsByBrandIdFlowUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BrandViewModel(
    private val listStockItemsByBrandIdFlowUseCase: ListStockItemsByBrandIdFlowUseCase,
) : ViewModel() {

    val listedStockItems: MutableLiveData<List<StockItem>> = MutableLiveData()

    fun listStockItemsByBrandId(brandId: Int) {
        viewModelScope.launch {
            listStockItemsByBrandIdFlowUseCase(brandId).collectLatest { stockItemsList ->
                listedStockItems.value = stockItemsList
            }
        }
    }
}