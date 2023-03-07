package com.ab.dev.shoesly.domain.useCase.base

interface BaseUseCase<O> {
    suspend operator fun invoke() : O
}