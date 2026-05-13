package com.kotlinpractice.composable_example.data

import com.kotlinpractice.composable_example.data.repository.UserRepositoryImpl
import com.kotlinpractice.composable_example.domain.GetUsersUseCase
import com.kotlinpractice.composable_example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(
        retrofit: Retrofit
    ): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        api: UserApi
    ): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    fun provideGetUsersUseCase(
        repository: UserRepository
    ): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }
}