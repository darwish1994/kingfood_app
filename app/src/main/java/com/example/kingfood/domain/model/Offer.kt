package com.example.kingfood.domain.model


import com.google.gson.annotations.SerializedName

data class Offer(
    @SerializedName("code")
    val code: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("title")
    val title: String,

)