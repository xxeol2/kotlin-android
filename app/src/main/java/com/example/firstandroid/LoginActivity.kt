package com.example.firstandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.firstandroid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.btnLogin.setOnClickListener {
            if (checkInput()) {
                Toast.makeText(this, "모든 입력 칸을 채워주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                Intent(this, ProfileActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }

        binding.tvId.text
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }

    private fun checkInput(): Boolean {
        return binding.editId.text.isNullOrBlank() || binding.editPw.text.isNullOrBlank()
    }

    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
//            binding.editId.setText(it.data?.getStringExtra("id"))
//            binding.editPw.setText(it.data?.getStringExtra("pw"))
            it.data?.let {
                binding.apply {
                    editId.setText(it.getStringExtra("id"))
                    editPw.setText(it.getStringExtra("pw"))
                }
            }
        }
    }
}