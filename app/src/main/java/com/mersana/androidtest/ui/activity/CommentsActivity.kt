package com.mersana.androidtest.ui.activity


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mersana.androidtest.R
import com.mersana.androidtest.base.BaseActivity
import com.mersana.androidtest.databinding.ActivityCommentsBinding
import com.mersana.androidtest.databinding.ActivityCommentsBindingImpl
import com.mersana.androidtest.model.Comment
import com.mersana.androidtest.ui.adapter.CommentsRecyclerViewAdapter
import com.mersana.androidtest.viewModel.CommentsViewModel

class CommentsActivity : BaseActivity<CommentsViewModel, ActivityCommentsBinding>() {
    private lateinit var selectedPost:List<Comment>
    var count=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        viewModel.data.observe(this, Observer {
            selectedPost=it
            binding.adapter = CommentsRecyclerViewAdapter(it,viewModel,count)
        })

        viewModel.status.observe(this, Observer {
            binding.show = it
        })
        binding.viewModel=viewModel
        binding.activity=this


        viewModel.clear.observe(this, Observer {
            binding.edittextCommentTextRecyclerComment.setText("")
        })



    }
    fun moreClick(){
        count++
        binding.adapter = CommentsRecyclerViewAdapter(selectedPost,viewModel,count)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
            return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getResourceLayoutId(): Int =R.layout.activity_comments

    override fun getClassViewModel(): Class<CommentsViewModel> = CommentsViewModel::class.java

    override fun getFactory(): ViewModelProvider.Factory =CommentsViewModel.Factory(intent.getParcelableExtra("Post")!!)
}