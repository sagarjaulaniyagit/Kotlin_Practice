package com.kotlinpractice.kotlin_flow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinpractice.databinding.AdapterCommentBinding
import com.kotlinpractice.kotlin_flow.model.AllCommentItem

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    private var allComment = mutableListOf<AllCommentItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterCommentBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val allComment = allComment[position]
        holder.binding.commentIdTextview.text = allComment.id.toString()
        holder.binding.nameTextview.text = allComment.name.toString()
        holder.binding.emailTextview.text = allComment.email.toString()
        holder.binding.commentTextview.text = allComment.body.toString()
    }

    override fun getItemCount(): Int {
        return allComment.size
    }

    class ViewHolder(val binding: AdapterCommentBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setCommentList(comment: List<AllCommentItem>) {
        this.allComment = comment.toMutableList()
        notifyDataSetChanged()
    }
}
