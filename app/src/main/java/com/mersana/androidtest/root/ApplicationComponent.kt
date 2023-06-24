package com.mersana.androidtest.root

import com.mersana.androidtest.database.DataBaseModule
import com.mersana.androidtest.database.initData.InitComment
import com.mersana.androidtest.database.initData.InitLike
import com.mersana.androidtest.database.initData.InitPost
import com.mersana.androidtest.database.initData.InitUser
import com.mersana.androidtest.viewModel.CommentsViewModel
import com.mersana.androidtest.viewModel.MainViewModel

import dagger.Component

@Component(
    modules = arrayOf(
        ApplicationModule::class,
        DataBaseModule::class
    ),
)

interface ApplicationComponent {

    // inject database to InitPost
    fun inject(target: InitPost)

    // inject database to InitPost
    fun inject(target: InitComment)

    // inject database to InitPost
    fun inject(target: InitUser)

    // inject database to InitPost
    fun inject(target: InitLike)

    // inject postAccess to mainViewModel
    fun inject(target: MainViewModel)
    fun inject(target: CommentsViewModel)



}