package com.example.kingfood.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kingfood.domain.model.User

@Dao
interface UserDao {


    @Query("SELECT * FROM User")
    fun getUser(): LiveData<List<User>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User?)

}