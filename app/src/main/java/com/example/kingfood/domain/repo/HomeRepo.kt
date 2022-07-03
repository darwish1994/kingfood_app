package com.example.kingfood.domain.repo

import com.example.kingfood.data.remote.response.HomeSection
import com.example.kingfood.utils.ResponseWrapper

interface HomeRepo {

    suspend fun getHome(): ResponseWrapper<HomeSection>
}