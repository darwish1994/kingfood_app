package com.example.kingfood.data.remote.request

data class RegisterRequest(
    val name: String,
    val phone: String,
    val address: String,
    val email: String,
    val password: String
)
