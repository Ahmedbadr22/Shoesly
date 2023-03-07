package com.ab.dev.shoesly.app.mappers

import com.ab.dev.shoesly.data.model.entities.brand.BrandEntity
import com.ab.dev.shoesly.data.model.response.success.BrandResponse
import com.ab.dev.shoesly.domain.models.data.Brand


fun BrandEntity.asBrand() : Brand = Brand(id, name, logo)
fun Brand.asBrandEntity() : BrandEntity = BrandEntity(id, name, logo)
fun BrandResponse.asBrand() : Brand = Brand(id, name, logo)