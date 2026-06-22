package com.kotlinpractice.composable_example.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlinpractice.composable_example.domain.model.User
import com.kotlinpractice.composable_example.domain.repository.UserRepository
import com.kotlinpractice.composable_example.domain.usecase.GetUsersUseCase
import com.kotlinpractice.composable_example.domain.usecase.InsertUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val insertUserUseCase: InsertUserUseCase,
    private val repository: UserRepository
) : ViewModel() {
    val users = getUsersUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000), emptyList()
    )

    init {
        syncUsers()
    }

    private fun syncUsers() {
        viewModelScope.launch {
            repository.syncUsers()
        }
    }

    fun addUser(
        name: String, email: String
    ) {
        viewModelScope.launch {
            insertUserUseCase(
                User(
                    id = System.currentTimeMillis().toInt(),
                    name = name, email = email
                )
            )
        }
    }
}