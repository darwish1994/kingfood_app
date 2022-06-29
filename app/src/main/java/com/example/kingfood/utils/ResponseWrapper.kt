package com.example.kingfood.utils

import com.google.gson.annotations.SerializedName

data class ResponseWrapper<T>(@SerializedName("data") val data: T,@SerializedName("message") val message: String? = null)
