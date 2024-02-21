package com.kotlinpractice.mvvm_practice_1.data.api

import com.kotlinpractice.mvvm_practice_1.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getUsers(): List<User>
}