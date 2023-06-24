package com.mersana.androidtest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    val username: String,
    @PrimaryKey (autoGenerate = true) val userId: Long=0
    ){

}