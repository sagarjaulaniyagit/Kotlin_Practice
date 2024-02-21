package com.kotlinpractice.hilt_practice.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlinpractice.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private var key: String? = null
    private var changeKey: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Intent().apply { putExtra("key", key) }
    }

    private fun handle() {
        key = intent.getStringExtra("key")
        changeKey = key + "change"

        binding.textview.text = key
//        binding.btnBck.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        binding.btnBck.setOnClickListener {
            startActivity(
                Intent(this, HiltActivity::class.java).apply { putExtra("key", key) })
        }
    }
}