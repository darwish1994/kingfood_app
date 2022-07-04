package com.example.kingfood.domain.repo

import com.example.kingfood.domain.model.CartItem
import com.example.kingfood.domain.model.Offer
import com.example.kingfood.domain.model.Product
import com.example.kingfood.utils.ResponseWrapper

interface ProductRepo {

    suspend fun getAllProducts():ResponseWrapper<List<Product>>

    suspend fun getOffers():ResponseWrapper<List<Offer>>

    suspend fun getHomeOffers():ResponseWrapper<List<Offer>>

    suspend fun getProduct(id:Int):ResponseWrapper<Product>

    suspend fun addToCart(id:Int,quantity:Int):ResponseWrapper<String>

    suspend fun getCart():ResponseWrapper<List<CartItem>>

    suspend fun removeItem(id: Int):ResponseWrapper<List<CartItem>>


}