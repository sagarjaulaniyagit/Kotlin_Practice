package com.kotlinpractice.test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlinpractice.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("calling", "onCreate_Activity_2")

        val postTitle = intent.getStringExtra(POST_TITLE)
        val postName = intent.getStringExtra(POST_NAME)

        Log.d("detail", postName + postTitle)
    }

    companion object {
        internal const val POST_TITLE = "post_title"
        internal const val POST_NAME = "post_name"

        fun getStartIntent(context: Context, name: String, title: String): Intent {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(POST_NAME, name)
            intent.putExtra(POST_TITLE, title)
            return intent
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("calling", "onRestart_Activity_2")
    }

    override fun onStart() {
        super.onStart()
        Log.d("calling", "onStart_Activity_2")
    }

    override fun onResume() {
        super.onResume()
        Log.d("calling", "onResume_Activity_2")
    }

    override fun onPause() {
        super.onPause()
        Log.d("calling", "onPause_Activity_2")
    }

    override fun onStop() {
        super.onStop()
        Log.d("calling", "onStop_Activity_2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("calling", "onDestroy_Activity_2")
    }
}