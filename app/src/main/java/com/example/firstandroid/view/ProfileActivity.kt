package com.example.firstandroid.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstandroid.R
import com.example.firstandroid.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private var position = FOLLOWER_LIST_POSITION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initTransactionEvent()
    }

    private fun initTransactionEvent() {
        val followerListFragment = FollowerListFragment()
        supportFragmentManager.beginTransaction().add(R.id.container_list, followerListFragment).commit()
    }

    companion object {
        const val FOLLOWER_LIST_POSITION = 1
        const val REPOSITORY_LIST_POSITION = 2
    }
}
