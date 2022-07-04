package com.example.kingfood.data.repo

import com.example.kingfood.data.local.UserDao
import com.example.kingfood.data.remote.call.AuthApi
import com.example.kingfood.data.remote.request.LoginRequest
import com.example.kingfood.data.remote.request.RegisterRequest
import com.example.kingfood.domain.model.User
import com.example.kingfood.domain.repo.AuthRepo
import com.example.kingfood.utils.ResponseWrapper
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val authApi: AuthApi, private val userDao: UserDao) :
    AuthRepo {
    override suspend fun login(email: String, password: String): ResponseWrapper<User> =
        authApi.login(
            LoginRequest(email, password)
        )

    override suspend fun register(
        name: String,
        address: String,
        phone: String,
        email: String,
        password: String
    ): ResponseWrapper<User> = authApi.register(
        RegisterRequest(
            name = name,
            phone = phone,
            email = email,
            address = address,
            password = password
        )
    )

    override suspend fun saveUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun getUser(): List<User> = userDao.getUser()


}