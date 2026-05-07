package com.kotlinpractice.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.kotlinpractice.R
import com.kotlinpractice.databinding.ActivityMain5Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("calling", "onCreate_Activity_1")
        replace(FirstFragment())

//        startActivity(SecondActivity.getStartIntent(this@MainActivity, "Pixel", "Android"))
    }

    fun launchNewActivity(v: View) {
        Log.d("calling", "launchNewActivity_Activity_1")
        startActivity(Intent(this, SecondActivity::class.java))
    }

    private fun replace(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_layout, fragment)
        fragmentTransaction.commit()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("calling", "onRestart_Activity_1")
    }

    override fun onStart() {
        super.onStart()
        Log.d("calling", "onStart_Activity_1")
    }

    override fun onResume() {
        super.onResume()
        Log.d("calling", "onResume_Activity_1")
    }

    override fun onPause() {
        super.onPause()
        Log.d("calling", "onPause_Activity_1")
    }

    override fun onStop() {
        super.onStop()
        Log.d("calling", "onStop_Activity_1")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("calling", "onDestroy_Activity_1")
    }

    fun newFragment(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}