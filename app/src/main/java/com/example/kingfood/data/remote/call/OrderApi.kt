package com.example.kingfood.data.remote.call

import com.example.kingfood.domain.model.Order
import com.example.kingfood.utils.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface OrderApi {

    @GET("order/create")
    suspend fun createOrder(@Query("user_id") userId: Int): ResponseWrapper<String>

    @GET("order")
    suspend fun getOrder(@Query("user_id") userId: Int): ResponseWrapper<List<Order>>
}