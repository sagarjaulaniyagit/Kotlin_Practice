package com.kotlinpractice.kotlin_flow.repository

import com.kotlinpractice.kotlin_flow.model.AllComment
import com.kotlinpractice.kotlin_flow.model.AllCommentItem
import com.kotlinpractice.kotlin_flow.model.CommentModel
import com.kotlinpractice.kotlin_flow.network.ApiService
import com.kotlinpractice.kotlin_flow.network.CommentApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.w3c.dom.Comment

class CommentsRepository(private val apiService: ApiService) {
    suspend fun getComment(id: Int): Flow<CommentApiState<CommentModel>> {
        return flow {
            val comment = apiService.getComment(id)
            emit(CommentApiState.success(comment))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllComment(): Flow<CommentApiState<AllComment>> {
        return flow {
            val allComment = apiService.getAllComment()
            emit(CommentApiState.success(allComment))
        }.flowOn(Dispatchers.IO)
    }
}