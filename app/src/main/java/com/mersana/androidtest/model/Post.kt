package com.mersana.androidtest.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post (

    val caption:String?,
    val imagePath:String?,
    val senderId: Long,
    val commentCount:Long,
    val likeCount:Long,
    @PrimaryKey val postId: Long,
        ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(caption)
        parcel.writeString(imagePath)
        parcel.writeLong(senderId)
        parcel.writeLong(commentCount)
        parcel.writeLong(likeCount)
        parcel.writeLong(postId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Post> {
        override fun createFromParcel(parcel: Parcel): Post {
            return Post(parcel)
        }

        override fun newArray(size: Int): Array<Post?> {
            return arrayOfNulls(size)
        }
    }
}
