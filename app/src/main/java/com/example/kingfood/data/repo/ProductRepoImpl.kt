package com.example.kingfood.data.repo

import com.example.kingfood.data.remote.call.ProductApi
import com.example.kingfood.domain.model.Offer
import com.example.kingfood.domain.model.Product
import com.example.kingfood.domain.repo.ProductRepo
import com.example.kingfood.utils.ResponseWrapper
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(private val productApi: ProductApi) : ProductRepo {
    override suspend fun getAllProducts(): ResponseWrapper<List<Product>> = productApi.allProduct()

    override suspend fun getOffers(): ResponseWrapper<List<Offer>> = productApi.allOffers()

    override suspend fun getHomeOffers(): ResponseWrapper<List<Offer>> = productApi.allOffers()
}