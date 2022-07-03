package com.example.kingfood.data.remote.call

import com.example.kingfood.data.remote.response.HomeSection
import com.example.kingfood.utils.ResponseWrapper
import retrofit2.http.GET

interface HomeApi {

    @GET("home")
    suspend fun getHome():ResponseWrapper<HomeSection>
}