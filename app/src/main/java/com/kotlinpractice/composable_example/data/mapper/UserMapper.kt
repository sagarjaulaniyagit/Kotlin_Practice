package com.kotlinpractice.composable_example.data.mapper

import com.kotlinpractice.composable_example.data.local.UserEntity
import com.kotlinpractice.composable_example.data.remote.UserDto
import com.kotlinpractice.composable_example.domain.model.User

fun UserEntity.toDomain() =
    User(
        id = id,
        name = name,
        email = email
    )

fun User.toEntity() =
    UserEntity(
        id = id,
        name = name,
        email = email
    )

fun UserDto.toEntity() =
    UserEntity(
        id = id,
        name = name,
        email = email
    )