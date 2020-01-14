package com.example.koinsharedviewmodelpractise.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.koinsharedviewmodelpractise.R
import com.example.koinsharedviewmodelpractise.databinding.ActivityMainBinding
import com.example.koinsharedviewmodelpractise.ui.screenOne.ScreenOneViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ScreenOneViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = setContentView(this, R.layout.activity_main)
//        binding.root'
        binding.lifecycleOwner = this
    }
}
