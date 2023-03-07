package com.ab.dev.shoesly.presentation.mainActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ab.dev.shoesly.domain.useCase.color.GetColorsFromRemoteAndInsertToDBUseCase
import com.ab.dev.shoesly.domain.useCase.size.GetAllSizesFromRemoteAndInsertInLocalUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getColorsFromRemoteAndInsertToDBUseCase: GetColorsFromRemoteAndInsertToDBUseCase,
    private val getAllSizesFromRemoteAndInsertInLocalUseCase: GetAllSizesFromRemoteAndInsertInLocalUseCase
) : ViewModel() {

    fun loadColorsFromRemoteServer() {
        viewModelScope.launch {
            getColorsFromRemoteAndInsertToDBUseCase()
        }
    }

    fun loadSizesFromRemoteServer() {
        viewModelScope.launch {
            getAllSizesFromRemoteAndInsertInLocalUseCase()
        }
    }

}