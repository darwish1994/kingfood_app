package com.example.kingfood.domain.repo

import androidx.lifecycle.LiveData
import com.example.kingfood.domain.model.User
import com.example.kingfood.utils.ResponseWrapper

interface AuthRepo {

    suspend fun login(email: String, password: String): ResponseWrapper<User>

    suspend fun register(
        name: String,
        address: String,
        phone: String,
        email: String,
        password: String
    ): ResponseWrapper<User>

    suspend fun saveUser(user: User)

    fun getUser(): LiveData<List<User>>


}