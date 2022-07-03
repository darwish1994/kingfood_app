package com.example.kingfood.presnter.splash

import androidx.lifecycle.viewModelScope
import com.example.kingfood.domain.model.User
import com.example.kingfood.domain.usecase.UserUseCase
import com.example.kingfood.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val userUseCase: UserUseCase) : BaseViewModel() {
    suspend fun getCurrentUser()=userUseCase.invoke()



}