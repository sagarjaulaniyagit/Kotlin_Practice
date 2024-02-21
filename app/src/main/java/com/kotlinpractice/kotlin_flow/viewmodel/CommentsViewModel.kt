package com.kotlinpractice.kotlin_flow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlinpractice.kotlin_flow.model.AllComment
import com.kotlinpractice.kotlin_flow.model.AllCommentItem
import com.kotlinpractice.kotlin_flow.model.CommentModel
import com.kotlinpractice.kotlin_flow.network.CommentApiState
import com.kotlinpractice.kotlin_flow.network.Status
import com.kotlinpractice.kotlin_flow.repository.CommentsRepository
import com.kotlinpractice.kotlin_flow.utils.AppConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CommentsViewModel : ViewModel() {
    private val repository = CommentsRepository(AppConfig.ApiService())

    val commentState = MutableStateFlow(CommentApiState(Status.LOADING, CommentModel(), ""))
    val allComment = MutableStateFlow(CommentApiState(Status.LOADING, AllComment(), ""))

    init {
        getNewComment(1)
        getAllComment()
    }

    fun getNewComment(id: Int) {
        commentState.value = CommentApiState.loading()
        viewModelScope.launch {
            repository.getComment(id)
                .catch { commentState.value = CommentApiState.error(it.message.toString()) }
                .collect {
                    commentState.value = CommentApiState.success(it.data)
                }
        }
    }

    fun getAllComment() {
        allComment.value = CommentApiState.loading()
        viewModelScope.launch {
            repository.getAllComment()
                .catch { allComment.value = CommentApiState.error(it.message.toString()) }
                .collect {
                    allComment.value = CommentApiState.success(it.data)
                }
        }
    }
}

