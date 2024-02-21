package com.kotlinpractice.mvvm_practice_1.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlinpractice.mvvm_practice_1.data.api.ApiHelper
import com.kotlinpractice.mvvm_practice_1.data.repository.MainRepository
import com.kotlinpractice.mvvm_practice_1.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(MainRepository(apiHelper)) as T
        throw IllegalArgumentException("Unknown class name")
    }
}