package com.kotlinpractice.kotlin_flow.model

data class AllComment(
	val allComment: List<AllCommentItem?>? = null
)

data class AllCommentItem(
	val name: String? = null,
	val postId: Int? = null,
	val id: Int? = null,
	val body: String? = null,
	val email: String? = null
)

