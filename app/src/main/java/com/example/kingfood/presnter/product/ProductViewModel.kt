package com.example.kingfood.presnter.product

import androidx.lifecycle.viewModelScope
import com.example.kingfood.domain.model.Product
import com.example.kingfood.domain.usecase.AddToCartUseCase
import com.example.kingfood.domain.usecase.ProductUseCase
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.SingleLiveEvent
import com.example.kingfood.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productUseCase: ProductUseCase,
    private val addToCartUseCase: AddToCartUseCase
) :
    BaseViewModel() {

    val productLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<Product>>>() }
    val cartLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<String>>>() }

    fun getProduct(id: Int) = productUseCase.invoke(id).onEach {
        productLiveData.value = it
    }.launchIn(viewModelScope)


    fun addToCart(id: Int, quantity: Int) = addToCartUseCase.invoke(id, quantity).onEach {
        cartLiveData.value = it
    }.launchIn(viewModelScope)

}