package com.ab.dev.shoesly.data.repository.shoe

import com.ab.dev.shoesly.data.model.entities.shoe.ShoeEntity
import com.ab.dev.shoesly.data.model.entities.shoe.ShoeWithBrandAndReviews
import com.ab.dev.shoesly.data.source.local.source.shoe.ShoeLocalDataSource
import com.ab.dev.shoesly.domain.repository.shoe.ShoeRepository

class ShoeRepositoryImpl(
    private val shoeLocalDataSource: ShoeLocalDataSource
) : ShoeRepository {
    override suspend fun getShoeById(id: Int): ShoeEntity {
        return shoeLocalDataSource.getShoeById(id)
    }

    override suspend fun getShoeWithBrandById(id: Int): ShoeWithBrandAndReviews {
        return shoeLocalDataSource.getShoeWithBrandById(id)
    }

    override suspend fun insertShoe(shoeEntity: ShoeEntity) {
        shoeLocalDataSource.insertShoe(shoeEntity)
    }

    override suspend fun insertShoes(shoesEntity: List<ShoeEntity>) {
        shoeLocalDataSource.insertShoes(shoesEntity)
    }

    override suspend fun listShoes(): List<ShoeWithBrandAndReviews> {
        return shoeLocalDataSource.listShoes()
    }
}