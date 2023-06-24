package com.mersana.androidtest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mersana.androidtest.databinding.RecyclerviewCommentsItemBinding
import com.mersana.androidtest.model.Comment
import com.mersana.androidtest.viewModel.CommentsViewModel
import com.mersana.androidtest.viewModel.MainViewModel


class CommentsRecyclerViewAdapter (private val commentsList: List<Comment>,private val viewModel: CommentsViewModel,private  val count:Int) :
    RecyclerView.Adapter<CommentsRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewCommentsItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding,viewModel)
    }

    override fun getItemCount(): Int {
//        return commentsList.size
        if(commentsList.size<10 || commentsList.size<10*count)
            return commentsList.size
        else
            return 10*count
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(commentsList[position])
    }

    class Holder(private val binding: RecyclerviewCommentsItemBinding ,private val viewModel: CommentsViewModel) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: Comment) {
            binding.item = comment
            binding.viewModel=viewModel
            binding.executePendingBindings()
        }
    }
}