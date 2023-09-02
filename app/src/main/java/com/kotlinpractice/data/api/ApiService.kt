package com.kotlinpractice.data.api

import com.kotlinpractice.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getUsers(): List<User>
}