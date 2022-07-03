package com.example.kingfood.domain.model


import com.google.gson.annotations.SerializedName

data class Product(
    val details: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,

)