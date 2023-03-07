package com.ab.dev.shoesly.data.source.local.source.shoe

import com.ab.dev.shoesly.data.model.entities.shoe.ShoeEntity
import com.ab.dev.shoesly.data.model.entities.shoe.ShoeWithBrandAndReviews
import com.ab.dev.shoesly.data.source.local.db.dao.ShoeDao

class ShoeLocalDataSourceImpl(
    private val shoeDao: ShoeDao
) : ShoeLocalDataSource {

    override suspend fun getShoeById(id: Int): ShoeEntity {
        return shoeDao.getShoeById(id)
    }

    override suspend fun getShoeWithBrandById(id: Int): ShoeWithBrandAndReviews {
        return shoeDao.getShoeWithBrandAndReviewsById(id)
    }

    override suspend fun insertShoe(shoeEntity: ShoeEntity) {
        shoeDao.insertShoe(shoeEntity)
    }

    override suspend fun insertShoes(shoesEntity: List<ShoeEntity>) {
        shoeDao.insertShoes(shoesEntity)
    }

    override suspend fun listShoes(): List<ShoeWithBrandAndReviews> {
        return shoeDao.listShoes()
    }

}