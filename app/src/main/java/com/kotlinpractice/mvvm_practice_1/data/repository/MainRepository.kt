package com.kotlinpractice.mvvm_practice_1.data.repository

import com.kotlinpractice.mvvm_practice_1.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}