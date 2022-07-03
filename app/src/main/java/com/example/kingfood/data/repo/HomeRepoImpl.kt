package com.example.kingfood.data.repo

import com.example.kingfood.data.remote.call.HomeApi
import com.example.kingfood.data.remote.response.HomeSection
import com.example.kingfood.domain.repo.HomeRepo
import com.example.kingfood.utils.ResponseWrapper
import javax.inject.Inject

class HomeRepoImpl @Inject constructor(private val homeApi: HomeApi) : HomeRepo {

    override suspend fun getHome(): ResponseWrapper<HomeSection> = homeApi.getHome()
}