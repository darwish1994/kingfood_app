package com.example.kingfood.di

import com.example.kingfood.data.remote.call.AuthApi
import com.example.kingfood.data.remote.call.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApisModule {

    @Provides
    @Singleton
    fun provideAuthApiCalls(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideHomeApiCalls(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)




}