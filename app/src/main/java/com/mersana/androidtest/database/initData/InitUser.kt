package com.mersana.androidtest.database.initData

import com.mersana.androidtest.database.dataAccess.PostAccess
import com.mersana.androidtest.database.dataAccess.UserAccess
import com.mersana.androidtest.model.Post
import com.mersana.androidtest.model.User
import com.mersana.androidtest.root.ParentApplication
import javax.inject.Inject

class InitUser {

    @Inject
    lateinit var userAccess: UserAccess

    private lateinit var data: User

    init {
        ParentApplication.instance.getComponent().inject(this)
        definitionUsers()
    }

    fun definitionUsers() {

        data = User("sudabeh")
        userAccess.insertUser(data)

        data = User("reza")
        userAccess.insertUser(data)

        data = User("mersana")
        userAccess.insertUser(data)

        data = User("mohamad")
        userAccess.insertUser(data)


    }
}