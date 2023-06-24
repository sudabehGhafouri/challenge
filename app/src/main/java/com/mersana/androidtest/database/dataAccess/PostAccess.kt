package com.mersana.androidtest.database.dataAccess

import android.util.Log
import androidx.lifecycle.LiveData
import com.mersana.androidtest.database.DataBase
import com.mersana.androidtest.model.Post
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostAccess(
    private val database: DataBase,
) {

    fun insertPost(post: Post) {


        Completable.fromAction { database.postDao().insertPost(post) }
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

    fun insertMyPost(post: Post){
        CoroutineScope(Dispatchers.IO).launch {

                database.postDao().insert(post )

        }
    }

    fun getPosts(): LiveData<List<Post>> = database.postDao().getPost()


    fun updateCommentCountByPostId(
        postId: Long,
        commentCount: Int?
    ) {
        Completable.fromAction { database.postDao().updateCommentCountByPostId(postId,commentCount) }
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {}
                override fun onComplete() {
                       Log.e("update","post update")
                }

                override fun onError(e: Throwable) {
                    Log.e("update","post update  error")
                }
            })
    }

}