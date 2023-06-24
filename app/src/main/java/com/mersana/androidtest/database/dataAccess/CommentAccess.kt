package com.mersana.androidtest.database.dataAccess

import androidx.lifecycle.LiveData
import com.mersana.androidtest.database.DataBase
import com.mersana.androidtest.model.Comment
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CommentAccess (
    private val database: DataBase,
) {

    fun insertComment(comment: Comment) {


        Completable.fromAction { database.commentDao().insertComment(comment) }
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

    fun getComments(): LiveData<List<Comment>> = database.commentDao().getComments()
    fun getCommentsByPostId(postId:Long ): LiveData<List<Comment>> = database.commentDao().getCommentsByPostId(postId)
}
