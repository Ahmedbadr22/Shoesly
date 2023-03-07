package com.ab.dev.shoesly.data.source.local.source.shoe

import com.ab.dev.shoesly.data.model.entities.shoe.ShoeEntity
import com.ab.dev.shoesly.data.model.entities.shoe.ShoeWithBrandAndReviews

interface ShoeLocalDataSource {
    suspend fun getShoeById(id: Int) : ShoeEntity
    suspend fun getShoeWithBrandById(id: Int) : ShoeWithBrandAndReviews
    suspend fun insertShoe(shoeEntity: ShoeEntity)
    suspend fun insertShoes(shoesEntity: List<ShoeEntity>)
    suspend fun listShoes() : List<ShoeWithBrandAndReviews>
}