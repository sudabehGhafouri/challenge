package com.mersana.androidtest.database.dataAccess

import androidx.lifecycle.LiveData
import com.mersana.androidtest.database.DataBase
import com.mersana.androidtest.model.Like
import com.mersana.androidtest.model.User
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LikeAccess (
    private val database: DataBase,
){

    fun insertLike(like: Like) {


        Completable.fromAction { database.likeDao().insertLike(like) }
            .subscribeOn(
                Schedulers.io()
            )
            .observeOn(AndroidSchedulers.mainThread()).subscribe(object :
                CompletableObserver {
                override fun onSubscribe(d: Disposable) {}
                override fun onComplete() {
                }

                override fun onError(e: Throwable) {
                }
            })
    }

    fun getUsers(): LiveData<List<User>> = database.userDao().getUsers()
}
