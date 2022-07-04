package com.example.kingfood.domain.model


import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("id")
    val id: Int,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total")
    val total: Int
)