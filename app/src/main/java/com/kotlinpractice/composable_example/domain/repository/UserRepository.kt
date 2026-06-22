package com.kotlinpractice.composable_example.domain.repository

import com.kotlinpractice.composable_example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>

    suspend fun insertUser(user: User)

    suspend fun syncUsers()
}