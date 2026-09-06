package com.kotlinpractice.composable_example.domain.usecase

import com.kotlinpractice.composable_example.domain.model.User
import com.kotlinpractice.composable_example.domain.repository.UserRepository

class InsertUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(user: User) {
        repository.insertUser(user)
    }
}