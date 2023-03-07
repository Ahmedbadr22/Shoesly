package com.ab.dev.shoesly.data.model.entities.brand

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ab.dev.shoesly.app.constants.DB

@Entity(tableName = DB.BRANDS_ENTITY)
data class BrandEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val logo: String
)
