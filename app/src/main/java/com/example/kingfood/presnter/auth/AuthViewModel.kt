package com.example.kingfood.presnter.auth

import androidx.lifecycle.viewModelScope
import com.example.kingfood.domain.model.User
import com.example.kingfood.domain.usecase.LoginUseCase
import com.example.kingfood.domain.usecase.RegisterUseCase
import com.example.kingfood.domain.usecase.UserUseCase
import com.example.kingfood.utils.Resource
import com.example.kingfood.utils.ResponseWrapper
import com.example.kingfood.utils.SingleLiveEvent
import com.example.kingfood.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase,
    private val userUseCase: UserUseCase
) : BaseViewModel() {
     val authLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<User>>>() }
//     val userLiveData by lazy { userUseCase.invoke() }

    fun login(email: String, password: String) {
        loginUseCase.invoke(email, password).onEach {
            authLiveData.value = it
        }.launchIn(viewModelScope)
    }

    fun register(name: String, address: String, phone: String, email: String, password: String) {
        registerUseCase.invoke(name, address, phone, email, password).onEach {
            authLiveData.value = it
        }.launchIn(viewModelScope)
    }



}