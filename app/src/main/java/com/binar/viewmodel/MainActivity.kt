package com.binar.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.binar.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btnIncrement.setOnClickListener {
                viewModel.incrementCount()
            }
            btnDecrement.setOnClickListener {
                viewModel.decrementCount()
            }
        }

        updateUI()
    }

//    private fun incrementCount() {
//        count += 1
//    }
//
//    private fun decrementCount() {
//        if (count > 0) count -= 1
//    }

    private fun updateUI() {
//        binding.tvCounter.text = count.toString()
        viewModel.mCount.observe(this) {
            count ->
            binding.tvCounter.text = count.toString() //Live Data
        }
    }
}