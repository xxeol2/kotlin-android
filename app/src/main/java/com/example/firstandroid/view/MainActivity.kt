package com.example.firstandroid.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.firstandroid.R
import com.example.firstandroid.adapter.ViewPagerAdapter
import com.example.firstandroid.databinding.ActivityMainBinding
import com.example.firstandroid.databinding.ActivityProfileBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initView()
    }

    private fun initAdapter() {
        binding.vpMain.adapter = ViewPagerAdapter(this@MainActivity)
//            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
//                override fun onPageSelected(position: Int) {
//                    binding.bnvMain.menu.getItem(position).isChecked = true
//                }
//            })

        binding.vpMain.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bnvMain.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun initView() {
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_profile -> {
                    binding.vpMain.currentItem = PROFILE_POSITION
                    return@setOnItemSelectedListener true
                }
                R.id.menu_home -> {
                    binding.vpMain.currentItem = HOME_POSITION
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vpMain.currentItem = CAMERA_POSITION
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object {
        const val PROFILE_POSITION = 0
        const val HOME_POSITION = 1
        const val CAMERA_POSITION = 2
    }
}