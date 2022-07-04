package com.example.kingfood.data.repo

import com.example.kingfood.data.local.UserDao
import com.example.kingfood.data.remote.call.OrderApi
import com.example.kingfood.domain.model.Order
import com.example.kingfood.domain.repo.OrderRepo
import com.example.kingfood.utils.ResponseWrapper
import javax.inject.Inject

class OrderRepoImpl @Inject constructor(
    private val orderApi: OrderApi,
    private val userDao: UserDao
) : OrderRepo {
    override suspend fun createOrder(): ResponseWrapper<String> {
        val user = userDao.currentUser()
        return orderApi.createOrder(user.id)

    }

    override suspend fun getOrders(): ResponseWrapper<List<Order>> {
        val user = userDao.currentUser()
        return orderApi.getOrder(user.id)
    }
}