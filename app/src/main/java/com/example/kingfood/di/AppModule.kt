package com.example.kingfood.di

import android.content.Context
import androidx.room.Room
import com.example.kingfood.data.local.AppDatabase
import com.example.kingfood.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "kingfoodDatabase").build()

    @Provides
    @Singleton
    fun provideCityDao(database: AppDatabase): UserDao =  database.userDao()


}