package com.mersana.androidtest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mersana.androidtest.database.dao.CommentDao
import com.mersana.androidtest.database.dao.LikeDao
import com.mersana.androidtest.database.dao.PostDao
import com.mersana.androidtest.database.dao.UserDao
import com.mersana.androidtest.model.Comment
import com.mersana.androidtest.model.Like
import com.mersana.androidtest.model.Post
import com.mersana.androidtest.model.User


@Database(entities = [Comment::class, Like::class,Post::class,User::class],version = 1,exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class DataBase: RoomDatabase() {
    abstract fun commentDao() : CommentDao
    abstract fun likeDao() : LikeDao
    abstract fun postDao() : PostDao
    abstract fun userDao() : UserDao


    companion object {

        @Volatile
        private var INSTANCE: DataBase? = null
        fun getInstance(context: Context): DataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "subscriber_data_database"
                    )

                        .build()
                }
                return instance
            }
        }
    }
}