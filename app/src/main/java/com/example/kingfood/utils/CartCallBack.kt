package com.example.kingfood.utils

import com.example.kingfood.domain.model.CartItem

interface CartCallBack {

    fun onClick(cartItem: CartItem)
}