package com.mersana.androidtest.database.initData

import com.mersana.androidtest.database.dataAccess.CommentAccess
import com.mersana.androidtest.database.dataAccess.PostAccess
import com.mersana.androidtest.model.Comment
import com.mersana.androidtest.model.Post
import com.mersana.androidtest.root.ParentApplication
import javax.inject.Inject

class InitComment {

    @Inject
    lateinit var commentAccess: CommentAccess

    private lateinit var data: Comment

    init {
        ParentApplication.instance.getComponent().inject(this)
        definitionComments()
    }

    fun definitionComments() {

     data = Comment(0,"طبیعت نمایش قدرت و خلاقیت خداست",0)
        commentAccess.insertComment(data)
        data = Comment(0,"واقعا زیباست",0)
        commentAccess.insertComment(data)
        data = Comment(1,"طبیعت قزوین",0)
        commentAccess.insertComment(data)
        data = Comment(1,"تابلوی نقاشی واقعی",0)
        commentAccess.insertComment(data)

        for (number in 0 .. 30) {
            data = Comment(2, "تابلوی نقاشی واقعی ", 0)
            commentAccess.insertComment(data)
        }


    }
}