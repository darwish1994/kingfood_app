package com.example.kingfood.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface NetworkRemoteServiceCall {
    suspend fun <T> safeApiCallGeneric(apiCall: suspend () -> T): Resource<T> =
        withContext(Dispatchers.IO) {
            try {
                // invoke suspend service method
                val response = apiCall.invoke()
                Resource.Success(response)
            } catch (throwable: Exception) {
                if (throwable is HttpException)
                Resource.Error((throwable as HttpException).response()?.errorBody()?.string()?:"SomeTHING Wrong try again")
                else
                Resource.Error(throwable.message?:"SomeTHING Wrong try again")
            }
        }
}