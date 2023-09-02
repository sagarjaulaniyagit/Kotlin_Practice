package com.kotlinpractice.data.repository

import com.kotlinpractice.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}