package com.kotlinpractice.composable_example.domain.usecase

import com.kotlinpractice.composable_example.domain.repository.UserRepository

class GetUsersUseCase(private val repository: UserRepository) {
    operator fun invoke() = repository.getUsers()
}