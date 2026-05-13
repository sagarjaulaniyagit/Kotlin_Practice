package com.kotlinpractice.composable_example.data

import com.kotlinpractice.composable_example.data.model.UserDto
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<UserDto>

}