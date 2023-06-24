package com.mersana.androidtest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mersana.androidtest.model.Post
import com.mersana.androidtest.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user : User)


    @Query("select * from User")
    fun getUsers() : LiveData<List<User>>
}