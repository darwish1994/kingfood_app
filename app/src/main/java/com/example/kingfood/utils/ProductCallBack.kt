package com.example.kingfood.utils

import com.example.kingfood.domain.model.Product

interface ProductCallBack {

    fun onClick(product: Product)
}