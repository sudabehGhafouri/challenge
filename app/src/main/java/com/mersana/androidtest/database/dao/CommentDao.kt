package com.mersana.androidtest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mersana.androidtest.model.Comment
import com.mersana.androidtest.model.Post

@Dao
interface CommentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comment : Comment)


    @Query("select * from Comment")
    fun getComments() : LiveData<List<Comment>>

    @Query("select * from Comment  where postId=:postId ")
    fun getCommentsByPostId(postId:Long) : LiveData<List<Comment>>
}