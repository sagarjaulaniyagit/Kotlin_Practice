package com.kotlinpractice.composable_example.data.repository

import com.kotlinpractice.composable_example.data.UserApi
import com.kotlinpractice.composable_example.data.model.toDomain
import com.kotlinpractice.composable_example.domain.model.User
import com.kotlinpractice.composable_example.domain.repository.UserRepository

class UserRepositoryImpl(private val api: UserApi) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return api.getUsers().map {
            it.toDomain()
        }
    }
}