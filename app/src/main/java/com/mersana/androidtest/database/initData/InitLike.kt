package com.mersana.androidtest.database.initData

import com.mersana.androidtest.database.dataAccess.LikeAccess
import com.mersana.androidtest.database.dataAccess.PostAccess
import com.mersana.androidtest.model.Like
import com.mersana.androidtest.model.Post
import com.mersana.androidtest.root.ParentApplication
import javax.inject.Inject

class InitLike {

    @Inject
    lateinit var likeAccess: LikeAccess

    private lateinit var data: Like

    init {
        ParentApplication.instance.getComponent().inject(this)
        definitionLike()
    }

    fun definitionLike() {

        data = Like(0,0)
        likeAccess.insertLike(data)


    }
}