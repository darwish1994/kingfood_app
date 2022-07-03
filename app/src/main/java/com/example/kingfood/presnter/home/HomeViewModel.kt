package com.example.kingfood.presnter.home

import androidx.lifecycle.viewModelScope
import com.example.kingfood.data.remote.response.HomeSection
import com.example.kingfood.domain.usecase.HomeUseCase
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.SingleLiveEvent
import com.example.kingfood.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) : BaseViewModel() {

    val homeLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<HomeSection>>>() }

    fun getHome() = homeUseCase.invoke().onEach {
        homeLiveData.value = it
    }.launchIn(viewModelScope)


}