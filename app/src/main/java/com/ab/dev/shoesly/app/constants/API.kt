package com.ab.dev.shoesly.app.constants

object API {
    const val BASE_URL = "https://7b31-197-56-72-7.eu.ngrok.io"
    private const val AUTHENTICATION_APP = "/authentication"
    private const val STORE_APP = "/store"
    const val LOGIN_URL = "$AUTHENTICATION_APP/login"
    const val REGISTRATION_URL = "$AUTHENTICATION_APP/register-user"
    const val TOKEN_VERIFY_URL = "$AUTHENTICATION_APP/token/verify"

    const val AUTHORIZATION_HEADER = "Authorization"
    // Brand
    const val LIST_CREATE_BRAND_URL = "$STORE_APP/list-create-brand"

    // Stock
    const val BRAND_ID_FIELD = "brandId"
    const val LIST_SHOE_BY_BRAND_URL = "$STORE_APP/list-stock-items-by-brand/{$BRAND_ID_FIELD}"
    // orders
    const val LIST_USER_ORDERS_URL = "$STORE_APP/list-user-orders"
    // cart
    const val LIST_USER_CART_ITEMS_URL = "$STORE_APP/list-user-cart-items"
    // Color
    const val LIST_COLORS_URL = "$STORE_APP/list-create-color"
    // Size
    const val LIST_SIZES_URL = "$STORE_APP/list-create-size"
}