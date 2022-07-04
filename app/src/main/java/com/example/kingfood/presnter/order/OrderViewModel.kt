package com.example.kingfood.presnter.order

import androidx.lifecycle.viewModelScope
import com.example.kingfood.domain.model.Order
import com.example.kingfood.domain.usecase.GetOrderUseCase
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.SingleLiveEvent
import com.example.kingfood.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(private val orderUseCase: GetOrderUseCase) :
    BaseViewModel() {
    val orderLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<List<Order>>>>() }

    fun getOrder() = orderUseCase.invoke().onEach {
        orderLiveData.value = it
    }.launchIn(viewModelScope)

}