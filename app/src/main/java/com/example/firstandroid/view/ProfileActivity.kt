package com.example.firstandroid.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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
        val repositoryListFragment = RepositoryListFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_list, followerListFragment).commit()

        binding.apply {
            btnFollower.setOnClickListener {
                if (position == REPOSITORY_LIST_POSITION) {
                    fragmentManage(followerListFragment, FOLLOWER_LIST_POSITION)
                }
            }
            btnRepository.setOnClickListener{
                if (position == FOLLOWER_LIST_POSITION) {
                    fragmentManage(repositoryListFragment, REPOSITORY_LIST_POSITION)
                }
            }
        }
    }

    private fun fragmentManage(fragment: Fragment, pos: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_list, fragment).commit()
        position = pos
    }

    companion object {
        const val FOLLOWER_LIST_POSITION = 1
        const val REPOSITORY_LIST_POSITION = 2
    }
}

