package com.example.kingfood.di

import com.example.kingfood.data.local.UserDao
import com.example.kingfood.data.remote.call.AuthApi
import com.example.kingfood.data.remote.call.ProductApi
import com.example.kingfood.data.repo.AuthRepoImpl
import com.example.kingfood.data.repo.ProductRepoImpl
import com.example.kingfood.domain.repo.AuthRepo
import com.example.kingfood.domain.repo.ProductRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun provideAuthRepo(authApi: AuthApi,userDao: UserDao): AuthRepo = AuthRepoImpl(authApi,userDao)

    @Provides
    @Singleton
    fun provideProductRepo(productApi: ProductApi): ProductRepo = ProductRepoImpl(productApi)




}