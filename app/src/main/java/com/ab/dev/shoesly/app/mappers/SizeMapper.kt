package com.ab.dev.shoesly.app.mappers

import com.ab.dev.shoesly.data.model.entities.size.SizeEntity
import com.ab.dev.shoesly.data.model.response.success.SizeResponse
import com.ab.dev.shoesly.domain.models.data.Size


fun SizeResponse.asSizeEntity() = SizeEntity(id, size)
fun SizeEntity.asSize() = Size(id, size)