package com.example.kingfood.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kingfood.domain.model.User

@Dao
interface UserDao {


    @Query("SELECT * FROM User")
    suspend fun getUser(): List<User>

    @Query("SELECT * FROM User LIMIT 1")
    suspend fun currentUser(): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User?)

}