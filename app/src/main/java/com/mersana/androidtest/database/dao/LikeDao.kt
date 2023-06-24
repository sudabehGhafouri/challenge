package com.mersana.androidtest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mersana.androidtest.model.Like
import com.mersana.androidtest.model.Post

@Dao
interface LikeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLike(like : Like)


    @Query("select * from `Like`")
    fun getLikes() : LiveData<List<Like>>
}