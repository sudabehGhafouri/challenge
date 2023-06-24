package com.mersana.androidtest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mersana.androidtest.model.Post

@Dao
interface PostDao {

    @Query("SELECT * FROM Post ORDER BY postId ASC LIMIT :limit OFFSET :offset")
    suspend fun getPagedList(limit: Int, offset: Int): List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Post): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post : Post)


    @Query("select * from Post")
    fun getPost() : LiveData<List<Post>>


    @Update
    fun updatePost( postItem: Post?)


    @Query("UPDATE Post SET commentCount=:count  WHERE postId = :id")
    fun updateCommentCountByPostId(id: Long, count: Int?)

}