package com.kotlinpractice.composable_example.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinpractice.composable_example.presentation.ui.UserScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserScreen()
}