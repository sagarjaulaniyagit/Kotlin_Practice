package com.kotlinpractice.composable_example.presentation

import com.kotlinpractice.composable_example.domain.model.User

data class UserUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null
)