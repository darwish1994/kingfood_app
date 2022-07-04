package com.example.kingfood.domain.usecase

import com.example.kingfood.domain.repo.ProductRepo
import com.example.kingfood.utils.NetworkRemoteServiceCall
import com.example.kingfood.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val productRepo: ProductRepo) :
    NetworkRemoteServiceCall {

    operator fun invoke(id: Int) = flow {
        emit(Resource.Loading())
        emit(safeApiCallGeneric {
            productRepo.getProduct(id)
        })


    }
}