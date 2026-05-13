package com.kotlinpractice.composable_example.domain

import com.kotlinpractice.composable_example.domain.model.User
import com.kotlinpractice.composable_example.domain.repository.UserRepository

class GetUsersUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(): List<User> {
        return repository.getUsers()
    }
}