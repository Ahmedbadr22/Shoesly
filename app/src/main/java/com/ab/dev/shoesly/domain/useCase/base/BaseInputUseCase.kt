package com.ab.dev.shoesly.domain.useCase.base

interface BaseInputUseCase<I, O> {
    suspend operator fun invoke(input : I) : O
    fun validate(input: I)
}