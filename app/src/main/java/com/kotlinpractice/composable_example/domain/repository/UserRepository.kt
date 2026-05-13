package com.kotlinpractice.composable_example.domain.repository

import com.kotlinpractice.composable_example.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}