package com.kotlinpractice.hilt_practice.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.kotlinpractice.R
import com.kotlinpractice.databinding.ActivityHiltBinding
import com.kotlinpractice.hilt_practice.data_classes.Car
import com.kotlinpractice.hilt_practice.data_classes.CarViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {
    @Inject
    @Named("CarStringFirst")
    lateinit var racingCar: Car
    private val viewModel: CarViewModel by viewModels()
    private lateinit var binding: ActivityHiltBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiltBinding.inflate(layoutInflater)

        Log.d("HiltActivity", "The Racing car from Activity class:- $racingCar")
        viewModel
    }

    private fun send() {
        binding.btn.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java)
                .apply { putExtra("key", "value") })
        }
        if (intent.getStringExtra("key") != null) {
            binding.text.text = "key"
        }
    }
}