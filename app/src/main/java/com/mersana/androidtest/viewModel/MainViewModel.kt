package com.mersana.androidtest.viewModel

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mersana.androidtest.base.BaseViewModel
import com.mersana.androidtest.database.dao.PostDao
import com.mersana.androidtest.database.dataAccess.PostAccess
import com.mersana.androidtest.database.initData.InitComment
import com.mersana.androidtest.database.initData.InitLike
import com.mersana.androidtest.database.initData.InitPost
import com.mersana.androidtest.database.initData.InitUser
import com.mersana.androidtest.model.Post
import com.mersana.androidtest.paging.MainPagingSource
import com.mersana.androidtest.root.ParentApplication
import com.mersana.kotlinsample.utils.SingleLiveEvent
import javax.inject.Inject


class MainViewModel (private val dao: PostDao): BaseViewModel() {

    private val postSelect: SingleLiveEvent<Post> = SingleLiveEvent()

    @Inject
    lateinit var postAccess: PostAccess

    private val detailClick = MutableLiveData<Post>()


    init {
        ParentApplication.instance.getComponent().inject(this)

    }

    val dataMyPager = Pager(
        PagingConfig(
            pageSize = 10,
            enablePlaceholders = false,
            initialLoadSize = 10
        ),
    ) {
        MainPagingSource(dao)
    }.flow.cachedIn(viewModelScope)

    fun initDatabase() {

        var initPost = InitPost()
        var initcomment = InitComment()
        var initUser = InitUser()
        var initLike = InitLike()

    }


    fun detailClick(post: Post) {
        detailClick.postValue(post)
    }






    val click = Transformations.map(detailClick) {
        it
    }



    class Factory(private val dao: PostDao) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {

            return MainViewModel(dao) as T
        }
    }
}