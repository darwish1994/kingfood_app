package com.example.kingfood.data.remote.call

import com.example.kingfood.data.remote.request.LoginRequest
import com.example.kingfood.data.remote.request.RegisterRequest
import com.example.kingfood.domain.model.User
import com.example.kingfood.utils.ResponseWrapper
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("login")
    suspend fun login(@Body request: LoginRequest):ResponseWrapper<User>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest):ResponseWrapper<User>

}