package com.example.firstandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstandroid.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.btnSignUp.setOnClickListener {
            if (checkInput()) {
                Toast.makeText(this, "모든 입력 칸을 채워주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent().apply {
                    putExtra("id", binding.editId.text.toString())
                    putExtra("pw", binding.editPw.text.toString())
                }
                Log.d("kangmi", binding.editId.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun checkInput(): Boolean {
        return binding.editId.text.isNullOrBlank() || binding.editName.text.isNullOrBlank() || binding.editPw.text.isNullOrBlank()
    }
}