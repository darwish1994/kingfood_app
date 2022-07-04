package com.example.kingfood.domain.repo

import com.example.kingfood.domain.model.Order
import com.example.kingfood.utils.ResponseWrapper

interface OrderRepo {

    suspend fun createOrder():ResponseWrapper<String>

    suspend fun getOrders():ResponseWrapper<List<Order>>

}