package com.example.kingfood.domain.model


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("details")
    val details: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("title")
    val title: String? = null
)