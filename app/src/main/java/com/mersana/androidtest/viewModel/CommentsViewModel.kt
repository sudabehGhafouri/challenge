package com.mersana.androidtest.viewModel

import androidx.lifecycle.*
import com.mersana.androidtest.base.BaseViewModel
import com.mersana.androidtest.database.dataAccess.CommentAccess
import com.mersana.androidtest.database.dataAccess.PostAccess
import com.mersana.androidtest.database.initData.InitPost
import com.mersana.androidtest.model.Comment
import com.mersana.androidtest.model.Post
import com.mersana.androidtest.root.ParentApplication
import com.mersana.androidtest.ui.adapter.CommentsRecyclerViewAdapter
import javax.inject.Inject

class CommentsViewModel(val post: Post) : BaseViewModel() {

    @Inject
    lateinit var commentAccess: CommentAccess

    @Inject
    lateinit var postAccess: PostAccess

    private val sendClick = MutableLiveData<Boolean>()
    private val clearEditText = MutableLiveData<Boolean>()
    private lateinit var commentData: LiveData<List<Comment>>
    val commentText = MutableLiveData<String>()

    init {
        ParentApplication.instance.getComponent().inject(this)
        getComments()
    }

    private fun getComments() {
        commentData = commentAccess.getCommentsByPostId(postId = post.postId)

    }

    fun sendClick() {
        val comment = Comment(post.postId, commentText.value!!, post.senderId)
        commentAccess.insertComment(comment)
        clearEditText.postValue(true)
        //update comments count in post
        postAccess.updateCommentCountByPostId(post.postId, ((commentData.value)?.size)?.plus(1))
    }


    val data = Transformations.map(commentData) {
        it
    }

    val clear = Transformations.map(clearEditText) {
        it
    }

    val status = Transformations.map(commentData) {
        it.size > 10
    }


    class Factory(val post: Post) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {

            return CommentsViewModel(post) as T
        }
    }
}