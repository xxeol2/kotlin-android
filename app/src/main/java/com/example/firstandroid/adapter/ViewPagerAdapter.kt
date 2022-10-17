package com.example.firstandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstandroid.view.CameraFragment
import com.example.firstandroid.view.HomeFragment
import com.example.firstandroid.view.MainActivity
import com.example.firstandroid.view.ProfileFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            MainActivity.PROFILE_POSITION -> ProfileFragment()
            MainActivity.HOME_POSITION -> HomeFragment()
            else -> CameraFragment()
        }
    }
}