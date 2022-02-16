package com.example.firstandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.firstandroid.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}