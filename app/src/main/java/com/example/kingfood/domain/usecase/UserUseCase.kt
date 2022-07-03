package com.example.kingfood.domain.usecase

import com.example.kingfood.domain.repo.AuthRepo
import javax.inject.Inject

class UserUseCase @Inject constructor(private val authRepo: AuthRepo) {
   suspend operator fun invoke() = authRepo.getUser()
}