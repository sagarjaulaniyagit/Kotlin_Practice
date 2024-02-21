package com.kotlinpractice.hilt_practice.data_classes

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class CarViewModel @Inject constructor(@Named("CarStringSecond") simpleCar: Car) : ViewModel() {
    init {
        Log.d("CarViewModelLog", "Simple car from ViewModel:- $simpleCar")
    }
}
