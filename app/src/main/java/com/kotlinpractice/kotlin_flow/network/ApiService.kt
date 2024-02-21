package com.kotlinpractice.kotlin_flow.network

import com.kotlinpractice.kotlin_flow.model.AllComment
import com.kotlinpractice.kotlin_flow.model.AllCommentItem
import com.kotlinpractice.kotlin_flow.model.CommentModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/comments/{id}")
    suspend fun getComment(@Path("id") id: Int): CommentModel

    @GET("/comments")
    suspend fun getAllComment(): AllComment
}