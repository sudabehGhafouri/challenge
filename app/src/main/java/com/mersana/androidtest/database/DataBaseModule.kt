package com.mersana.androidtest.database

import android.content.Context
import com.mersana.androidtest.database.dataAccess.CommentAccess
import com.mersana.androidtest.database.dataAccess.LikeAccess
import com.mersana.androidtest.database.dataAccess.PostAccess
import com.mersana.androidtest.database.dataAccess.UserAccess


import dagger.Module
import dagger.Provides

@Module
class DataBaseModule (val applicationContext: Context){



    @Provides
    fun provideRepoDataBase(): DataBase{
        return  DataBase.getInstance(applicationContext);
    }

    @Provides
    fun providePostAccess() : PostAccess {
        return PostAccess(provideRepoDataBase())
    }

    @Provides
    fun provideUserAccess() : UserAccess {
        return UserAccess(provideRepoDataBase())
    }

    @Provides
    fun provideCommentAccess() : CommentAccess {
        return CommentAccess(provideRepoDataBase())
    }

    @Provides
    fun provideLikeAccess() : LikeAccess {
        return LikeAccess(provideRepoDataBase())
    }
}