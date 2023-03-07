package com.ab.dev.shoesly.app.mappers

import com.ab.dev.shoesly.data.model.entities.shoe.ShoeEntity
import com.ab.dev.shoesly.data.model.entities.shoe.ShoeWithBrandAndReviews
import com.ab.dev.shoesly.domain.models.data.Shoe


fun ShoeWithBrandAndReviews.asShoe() : Shoe {
    // TODO("Replace emptyList() with the reviews")
    return Shoe(shoeEntity.id, shoeEntity.title, shoeEntity.description, shoeEntity.price, shoeEntity.image, brandEntity.asBrand(), emptyList())
}

fun Shoe.asShoeEntity() : ShoeEntity = ShoeEntity(id, title, description, image, price, brand.id)