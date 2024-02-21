package com.kotlinpractice.hilt_practice.data_classes

import android.content.Context
import com.kotlinpractice.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CarModule {
    @Provides
    @Singleton
    @Named("CarStringFirst")
    fun providingTheRacingCar() = Car("Ferrari")

    @Provides
    @Singleton
    @Named("CarStringSecond")
    fun providingTheSimpleCar(@ApplicationContext context: Context): Car =
        Car(context.getString(R.string.inject_string))
}