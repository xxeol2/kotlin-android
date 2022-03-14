package com.example.firstandroid.view

import android.app.Activity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.firstandroid.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
    }

    private fun initData() {
        binding.tvNameContent.text = intent.getStringExtra("name")
        binding.tvDetailContent.text = intent.getStringExtra("introduction")
    }
}