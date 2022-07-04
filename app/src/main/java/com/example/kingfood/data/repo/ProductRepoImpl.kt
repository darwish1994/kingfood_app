package com.example.kingfood.data.repo

import com.example.kingfood.data.local.UserDao
import com.example.kingfood.data.remote.call.ProductApi
import com.example.kingfood.domain.model.CartItem
import com.example.kingfood.domain.model.Offer
import com.example.kingfood.domain.model.Product
import com.example.kingfood.domain.repo.ProductRepo
import com.example.kingfood.utils.ResponseWrapper
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(
    private val productApi: ProductApi,
    private val userDao: UserDao
) : ProductRepo {
    override suspend fun getAllProducts(): ResponseWrapper<List<Product>> = productApi.allProduct()

    override suspend fun getOffers(): ResponseWrapper<List<Offer>> = productApi.allOffers()

    override suspend fun getHomeOffers(): ResponseWrapper<List<Offer>> = productApi.allOffers()
    override suspend fun getProduct(id: Int): ResponseWrapper<Product> {
        val user = userDao.currentUser()
        return productApi.product(id, user.id)
    }

    override suspend fun addToCart(id: Int, quantity: Int): ResponseWrapper<String> {
        val user = userDao.currentUser()
        return productApi.addToCart(id, user.id, quantity)
    }

    override suspend fun getCart(): ResponseWrapper<List<CartItem>> {
        val user = userDao.currentUser()
        return productApi.cart(user.id)
    }

    override suspend fun removeItem(id: Int): ResponseWrapper<List<CartItem>> {
        val user = userDao.currentUser()
        return productApi.removeCart(id, user.id)
    }


}