package com.kotlinpractice.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("thumbnailUrl")
    val image: String,
    @SerializedName("id")
    val userEmail: String,
    @SerializedName("albumId")
    val userId: String,
    @SerializedName("title")
    val userName: String
)
