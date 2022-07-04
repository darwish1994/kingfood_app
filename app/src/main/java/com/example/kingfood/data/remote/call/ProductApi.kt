package com.example.kingfood.data.remote.call

import com.example.kingfood.domain.model.CartItem
import com.example.kingfood.domain.model.Offer
import com.example.kingfood.domain.model.Product
import com.example.kingfood.utils.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {
    @GET("product")
    suspend fun allProduct(): ResponseWrapper<List<Product>>

    @GET("offers")
    suspend fun allOffers(): ResponseWrapper<List<Offer>>


    @GET("product/{id}")
    suspend fun product(
        @Path("id") productId: Int,
        @Query("user_id") userId: Int
    ): ResponseWrapper<Product>


    @GET("cart/add/{id}")
    suspend fun addToCart(
        @Path("id") id: Int,
        @Query("user_id") userId: Int,
        @Query("quantity") quantity: Int
    ): ResponseWrapper<String>


    @GET("cart")
    suspend fun cart( @Query("user_id") userId: Int):ResponseWrapper<List<CartItem>>

    @GET("cart/remove/{id}")
    suspend fun removeCart( @Path("id") id: Int, @Query("user_id") userId: Int):ResponseWrapper<List<CartItem>>


}