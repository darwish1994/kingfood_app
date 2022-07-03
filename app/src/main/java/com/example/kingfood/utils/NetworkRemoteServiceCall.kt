package com.example.kingfood.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface NetworkRemoteServiceCall {
    suspend fun <T> safeApiCallGeneric(apiCall: suspend () -> T): Resource<T> =
        withContext(Dispatchers.IO) {
            try {
                // invoke suspend service method
                val response = apiCall.invoke()
                Resource.Success(response)
            } catch (throwable: Exception) {
                Resource.Error("SomeTHING Wrong try again")
            }
        }
}