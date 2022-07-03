package com.example.kingfood.domain.usecase

import com.example.kingfood.domain.repo.AuthRepo
import javax.inject.Inject

class UserUseCase @Inject constructor(private val authRepo: AuthRepo) {
    operator fun invoke() = authRepo.getUser()
}