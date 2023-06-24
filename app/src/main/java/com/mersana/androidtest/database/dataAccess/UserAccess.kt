package com.mersana.androidtest.database.dataAccess

import androidx.lifecycle.LiveData
import com.mersana.androidtest.database.DataBase
import com.mersana.androidtest.model.Post
import com.mersana.androidtest.model.User
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserAccess (
    private val database: DataBase,
){

    fun insertUser(user: User) {


        Completable.fromAction { database.userDao().insertUser(user) }
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
