package com.ab.dev.shoesly.app.mappers

import com.ab.dev.shoesly.data.model.response.success.CartItemResponse
import com.ab.dev.shoesly.domain.models.data.CartItem


fun CartItemResponse.asCartItem() = CartItem(id, quantity, stockItemResponse.toStockItem())