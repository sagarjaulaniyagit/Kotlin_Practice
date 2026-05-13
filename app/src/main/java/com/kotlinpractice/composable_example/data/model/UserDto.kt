package com.kotlinpractice.composable_example.data.model

import com.kotlinpractice.composable_example.domain.model.User

data class UserDto(
    val id: Int,
    val name: String,
    val email: String
)


fun UserDto.toDomain(): User {
    return User(
        id = id,
        name = name,
        email = email
    )
}