package com.example.kingfood.domain.usecase

import com.example.kingfood.domain.repo.OrderRepo
import com.example.kingfood.domain.repo.ProductRepo
import com.example.kingfood.utils.NetworkRemoteServiceCall
import com.example.kingfood.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateOrderUseCase @Inject constructor(private val orderRepo: OrderRepo) :
    NetworkRemoteServiceCall {

    operator fun invoke() = flow {
        emit(Resource.Loading())
        emit(safeApiCallGeneric {
            orderRepo.createOrder()
        })


    }
}