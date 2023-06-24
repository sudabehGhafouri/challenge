package com.mersana.androidtest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comment(

    val postId: Long,
    val text:String,
    val userId: Long,
    @PrimaryKey(autoGenerate = true) val commentId: Long=0,
) {
}