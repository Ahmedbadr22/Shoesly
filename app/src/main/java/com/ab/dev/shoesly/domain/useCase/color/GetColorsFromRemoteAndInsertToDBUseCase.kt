package com.ab.dev.shoesly.domain.useCase.color

import com.ab.dev.shoesly.domain.repository.color.ColorRepository

class GetColorsFromRemoteAndInsertToDBUseCase(
    private val colorRepository: ColorRepository
) {
    suspend operator fun invoke() {
        colorRepository.getColorsFromRemoteAndInsertToLocalDataSource()
    }
}