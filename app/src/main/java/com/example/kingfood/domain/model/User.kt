package com.example.kingfood.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class User(
    @SerializedName("address")
    val address: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("email")
    val email: String,
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("role_id")
    val roleId: Int,


    )