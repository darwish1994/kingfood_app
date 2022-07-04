package com.example.kingfood.presnter.splash

import com.example.kingfood.domain.usecase.UserUseCase
import com.example.kingfood.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val userUseCase: UserUseCase) : BaseViewModel() {

     suspend fun getCurrentUser()=userUseCase.invoke()



}