package com.kotlinpractice.composable_example.data.remote

import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getUsers(): List<UserDto>
}