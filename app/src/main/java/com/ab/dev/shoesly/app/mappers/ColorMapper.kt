package com.ab.dev.shoesly.app.mappers

import com.ab.dev.shoesly.data.model.entities.color.ColorEntity
import com.ab.dev.shoesly.data.model.response.success.ColorResponse
import com.ab.dev.shoesly.domain.models.data.Color


fun ColorEntity.asColor() = Color(id, color, hex)
fun ColorResponse.asColor() = Color(id, color, hexColor)
fun ColorResponse.asColorEntity() = ColorEntity(id, color, hexColor)