package com.kotlinpractice.composable_example.data.repository

import com.kotlinpractice.composable_example.data.local.UserDao
import com.kotlinpractice.composable_example.data.mapper.toDomain
import com.kotlinpractice.composable_example.data.mapper.toEntity
import com.kotlinpractice.composable_example.data.remote.UserApi
import com.kotlinpractice.composable_example.domain.model.User
import com.kotlinpractice.composable_example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val api: UserApi,
    private val dao: UserDao
) : UserRepository {

    override fun getUsers(): Flow<List<User>> {
        return dao.getUsers().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertUser(user: User) {
        dao.insertUser(user.toEntity())
    }

    override suspend fun syncUsers() {
        try {
            val remoteUsers = api.getUsers()

            dao.insertUsers(
                remoteUsers.map { it.toEntity() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}