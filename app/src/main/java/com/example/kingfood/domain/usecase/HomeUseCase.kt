package com.example.kingfood.domain.usecase

import com.example.kingfood.data.remote.response.HomeSection
import com.example.kingfood.domain.repo.HomeRepo
import com.example.kingfood.utils.NetworkRemoteServiceCall
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepo: HomeRepo) : NetworkRemoteServiceCall {

    operator fun invoke() = flow<Resource<ResponseWrapper<HomeSection>>> {
        emit(Resource.Loading())
        emit(safeApiCallGeneric {
            homeRepo.getHome()
        })


    }
}