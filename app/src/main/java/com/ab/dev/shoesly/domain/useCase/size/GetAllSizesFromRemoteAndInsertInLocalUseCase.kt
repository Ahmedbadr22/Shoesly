package com.ab.dev.shoesly.domain.useCase.size

import com.ab.dev.shoesly.domain.repository.size.SizeRepository

class GetAllSizesFromRemoteAndInsertInLocalUseCase(
    private val sizeRepository: SizeRepository
) {

    suspend operator fun invoke() {
        sizeRepository.getSizesFromRemoteAndInsertToLocalDataSource()
    }
}