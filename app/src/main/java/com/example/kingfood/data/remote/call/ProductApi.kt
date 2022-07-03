package com.example.kingfood.data.remote.call

import com.example.kingfood.domain.model.Offer
import com.example.kingfood.domain.model.Product
import com.example.kingfood.utils.ResponseWrapper
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun allProduct():ResponseWrapper<List<Product>>
    @GET("offers")
    suspend fun allOffers():ResponseWrapper<List<Offer>>
}