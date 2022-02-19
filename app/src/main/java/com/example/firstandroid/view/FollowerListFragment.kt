package com.example.firstandroid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstandroid.R
import com.example.firstandroid.adapter.FollowerAdapter
import com.example.firstandroid.data.UserData
import com.example.firstandroid.databinding.FragmentFollowerListBinding

class FollowerListFragment : Fragment() {
    private lateinit var followerAdapter: FollowerAdapter
    private var _binding: FragmentFollowerListBinding? = null
    private val binding get() = _binding?: error("Binding이 초기화 되지 않았습니다")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = followerAdapter
        followerAdapter.userList.addAll(
            listOf(
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
            )
        )
        followerAdapter.notifyDataSetChanged()
    }

}