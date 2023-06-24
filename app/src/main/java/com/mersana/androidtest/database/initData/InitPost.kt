package com.mersana.androidtest.database.initData


import com.mersana.androidtest.database.dataAccess.PostAccess
import com.mersana.androidtest.model.Post
import com.mersana.androidtest.root.ParentApplication
import javax.inject.Inject

class InitPost {

    @Inject
    lateinit var postAccess: PostAccess

    private lateinit var data: Post

    init {
        ParentApplication.instance.getComponent().inject(this)
        definitionPost()
    }

     fun definitionPost() {


        data = Post("طبیعت زیبا","file:///android_asset/penguins.jpg",0,2,1,0)
        postAccess.insertMyPost(data)


         data = Post(" طبیعت زیبا طبیعت زیبا طبیعت زیبا   طبیعت زیبا طبیعت زیبا طبیعت زیبا طبیعت زیبا طبیعت زیبا","file:///android_asset/nature_picture.jpg",0,2,1,1)
         postAccess.insertMyPost(data)


         data = Post("طبیعت زیبا","file:///android_asset/tulips.jpg",0,31,1,2)
         postAccess.insertMyPost(data)


        for(number in 3 until  40){
             data = Post("طبیعت زیبا","file:///android_asset/light.jpg",0,0,1, number.toLong())
             postAccess.insertMyPost(data)
         }




    }
}