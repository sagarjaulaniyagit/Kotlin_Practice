package com.kotlinpractice.kotlin_flow.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kotlinpractice.databinding.ActivityMain4Binding
import com.kotlinpractice.kotlin_flow.adapter.CommentAdapter
import com.kotlinpractice.kotlin_flow.network.Status
import com.kotlinpractice.kotlin_flow.viewmodel.CommentsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var main4Binding: ActivityMain4Binding
    private lateinit var viewModel: CommentsViewModel
    private lateinit var commentAdapter: CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main4Binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(main4Binding.root)

        viewModel = ViewModelProvider(this)[CommentsViewModel::class.java]
        main4Binding.recyclerView.adapter = commentAdapter
        main4Binding.button.setOnClickListener {
            if (main4Binding.searchEditText.text.isNullOrEmpty()) {
                Toast.makeText(this, "Query can't be empty", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.getNewComment(main4Binding.searchEditText.text.toString().toInt())
            }
        }
        lifecycleScope.launch {
            viewModel.commentState.collect {
                when (it.status) {
                    Status.LOADING -> {
                        main4Binding.progressBar.isVisible = true
                    }

                    Status.SUCCESS -> {
                        main4Binding.progressBar.isVisible = false
                        it.data?.let { comment ->
                            main4Binding.commentIdTextview.text = comment.id.toString()
                            main4Binding.nameTextview.text = comment.name
                            main4Binding.emailTextview.text = it.data.email
                            main4Binding.commentTextview.text = comment.comment
                        }
                    }

                    else -> {
                        main4Binding.progressBar.isVisible = false
                        Toast.makeText(this@MainActivity, "${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }
}