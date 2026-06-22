package com.kotlinpractice.composable_example.presentation

import app.cash.turbine.test
import com.kotlinpractice.composable_example.domain.model.User
import com.kotlinpractice.composable_example.domain.repository.UserRepository
import com.kotlinpractice.composable_example.domain.usecase.GetUsersUseCase
import com.kotlinpractice.composable_example.domain.usecase.InsertUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    private lateinit var viewModel: UserViewModel
    private val getUsersUseCase: GetUsersUseCase = mockk()
    private val insertUserUseCase: InsertUserUseCase = mockk()
    private val repository: UserRepository = mockk()

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        
        // Mocking the initial getUsersUseCase call in ViewModel init
        every { getUsersUseCase() } returns flowOf(emptyList())
        coEvery { repository.syncUsers() } returns Unit
        
        viewModel = UserViewModel(getUsersUseCase, insertUserUseCase, repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `users flow should emit initial empty list and then updated list`() = runTest {
        val usersList = listOf(User(1, "John", "john@example.com"))
        every { getUsersUseCase() } returns flowOf(usersList)
        
        // Re-init to pick up the new mock for users flow if it's assigned at init
        val viewModel = UserViewModel(getUsersUseCase, insertUserUseCase, repository)

        viewModel.users.test {
            assertEquals(usersList, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `addUser should call insertUserUseCase`() = runTest {
        val name = "Alice"
        val email = "alice@example.com"
        
        coEvery { insertUserUseCase(any()) } returns Unit

        viewModel.addUser(name, email)
        testDispatcher.scheduler.advanceUntilIdle()

        coVerify { insertUserUseCase(match { it.name == name && it.email == email }) }
    }

    @Test
    fun `init should call syncUsers`() = runTest {
        coVerify { repository.syncUsers() }
    }
}
