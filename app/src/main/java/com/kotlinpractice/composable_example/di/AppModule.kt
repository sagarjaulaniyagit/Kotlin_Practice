package com.kotlinpractice.composable_example.di

import android.content.Context
import androidx.room.Room
import com.kotlinpractice.composable_example.data.local.AppDatabase
import com.kotlinpractice.composable_example.data.local.UserDao
import com.kotlinpractice.composable_example.data.remote.UserApi
import com.kotlinpractice.composable_example.data.repository.UserRepositoryImpl
import com.kotlinpractice.composable_example.domain.repository.UserRepository
import com.kotlinpractice.composable_example.domain.usecase.GetUsersUseCase
import com.kotlinpractice.composable_example.domain.usecase.InsertUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "user_db"
        ).build()
    }

    @Provides
    fun provideDao(db: AppDatabase): UserDao = db.userDao()

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
    fun provideApi(
        retrofit: Retrofit
    ): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        api: UserApi, dao: UserDao
    ): UserRepository {
        return UserRepositoryImpl(
            api, dao
        )
    }

    @Provides
    fun provideGetUsersUseCase(
        repository: UserRepository
    ) = GetUsersUseCase(repository)

    @Provides
    fun provideInsertUserUseCase(
        repository: UserRepository
    ) = InsertUserUseCase(repository)
}