package com.example.kingfood.presnter.home

import androidx.lifecycle.viewModelScope
import com.example.kingfood.data.remote.response.HomeSection
import com.example.kingfood.domain.model.CartItem
import com.example.kingfood.domain.model.Product
import com.example.kingfood.domain.usecase.*
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.SingleLiveEvent
import com.example.kingfood.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase,
    private val userUseCase: UserUseCase,
    private val productsUseCase: ProductsUseCase,
    private val cartUseCase: CartUseCase,
    private val removeFromCartUseCase: RemoveFromCartUseCase,
    private val createOrderUseCase: CreateOrderUseCase
) : BaseViewModel() {

    val homeLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<HomeSection>>>() }
    val orderLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<String>>>() }
    val productLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<List<Product>>>>() }
    val cartLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<List<CartItem>>>>() }

    fun getHome() = homeUseCase.invoke().onEach {
        homeLiveData.value = it
    }.launchIn(viewModelScope)


    fun getAllProduct() = productsUseCase.invoke().onEach {
        productLiveData.value = it
    }.launchIn(viewModelScope)


    fun getCart() = cartUseCase.invoke().onEach {
        cartLiveData.value = it
    }.launchIn(viewModelScope)

    fun removeFromCart(id: Int) = removeFromCartUseCase.invoke(id).onEach {
        cartLiveData.value = it
    }.launchIn(viewModelScope)


    fun createOrder() = createOrderUseCase.invoke().onEach {
        orderLiveData.value = it
    }.launchIn(viewModelScope)


    suspend fun getUserData() = userUseCase.invoke()


}