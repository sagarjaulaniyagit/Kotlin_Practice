package com.kotlinpractice.mvvm_practice_1.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}