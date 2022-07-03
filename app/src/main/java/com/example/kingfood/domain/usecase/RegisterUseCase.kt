package com.example.kingfood.domain.usecase

import com.example.kingfood.domain.model.User
import com.example.kingfood.domain.repo.AuthRepo
import com.example.kingfood.utils.NetworkRemoteServiceCall
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val authRepo: AuthRepo) :
    NetworkRemoteServiceCall {

    operator fun invoke(
        name: String,
        address: String,
        phone: String,
        email: String,
        password: String
    ): Flow<Resource<ResponseWrapper<User>>> {
        return flow {
            emit(Resource.Loading())
            emit(
                safeApiCallGeneric {
                    authRepo.register(name, address, phone, email, password)
                }.also {
                    if (it is Resource.Success) {
                        it.data?.data?.let { it1 -> authRepo.saveUser(it1) }
                    }
                })
        }

    }
}