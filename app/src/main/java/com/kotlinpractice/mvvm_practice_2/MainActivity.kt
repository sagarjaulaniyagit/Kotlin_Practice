package com.kotlinpractice.mvvm_practice_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModelProvider
import com.kotlinpractice.R
import com.kotlinpractice.databinding.ActivityMain2Binding
import com.kotlinpractice.databinding.ActivityMain3Binding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private val adapter = MovieAdapter()
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository))[MainViewModel::class.java]
        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer { adapter.setMovieList(it) })
        viewModel.errorMessage.observe(this) { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        viewModel.loading.observe(this, Observer {
            if (it)
                binding.progressDialog.visibility = View.VISIBLE
            else binding.progressDialog.visibility = View.GONE
        })
        viewModel.getAllMovies()
    }
}