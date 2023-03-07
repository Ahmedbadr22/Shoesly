package com.ab.dev.shoesly.domain.useCase.stock

import android.util.Log
import com.ab.dev.shoesly.domain.models.data.StockItem
import com.ab.dev.shoesly.domain.repository.stock.StockRepository
import com.ab.dev.shoesly.domain.useCase.base.BaseInputUseCase
import kotlinx.coroutines.flow.Flow

class ListStockItemsByBrandIdFlowUseCase(
    private val stockRepository: StockRepository
) : BaseInputUseCase<Int, Flow<List<StockItem>>> {

    override suspend fun invoke(input: Int) : Flow<List<StockItem>> {
        return stockRepository.listStockItemsByBrandIdFlow(input)
    }

    override fun validate(input: Int) {
        if (input == 0) Log.d("ListStockUseCase", "=====> Cant Be Zero")
    }
}