package com.example.kingfood.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kingfood.domain.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}