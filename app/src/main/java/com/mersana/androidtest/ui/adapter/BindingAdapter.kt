package com.mersana.androidtest.ui.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.mersana.androidtest.R
import java.io.ByteArrayInputStream
import java.io.InputStream

class BindingAdapter {

    companion object {




        @JvmStatic
        @BindingAdapter("recyclerAdapter")
        fun RecyclerView.setAdapter(adapter: CommentsRecyclerViewAdapter?) {
            if (adapter != null)
                this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        }

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(imgView: ImageView, imgUrl: String){

            imgUrl?.let {
//                val imgUri = it.toUri().buildUpon().scheme("https").build()
                Glide.with(imgView.context)
                    .load(Uri.parse(imgUrl))
//                    .load(imgUrl)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.ic_chat)
                            .error(R.drawable.ic_favorite))
                    .override(6000, 300)
                    .fitCenter()
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgView)
            }
        }

    }
}
