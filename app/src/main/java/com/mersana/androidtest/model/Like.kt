package com.mersana.androidtest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Like (
    val postId: Long,
    val userId: Long,
    @PrimaryKey (autoGenerate = true) val likeId: Long=0,
        )