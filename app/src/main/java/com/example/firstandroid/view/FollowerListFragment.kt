package com.example.firstandroid.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
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
        listClickEvent()
    }

    private fun initAdapter() {
        val customDecoration = LinearSpaceDecoration(50)
        followerAdapter = FollowerAdapter().apply {
            userList.addAll(
                listOf(
                    UserData(R.drawable.ic_profile_image,"가나다", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다2", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다3", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다4", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다5", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다6", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다7", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다8", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다9", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다10", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다11", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다12", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다13", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다14", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다15", "가나다라"),
                    UserData(R.drawable.ic_profile_image,"가나다16", "가나다라"),
                )
            )
            notifyDataSetChanged()
        }
        binding.rvFollower.apply {
            addItemDecoration(customDecoration)
            adapter = followerAdapter
        }
    }

    private fun listClickEvent() {
        followerAdapter.setItemClickListener(object : FollowerAdapter.ItemClickListener {
            override fun onClick(data: UserData) {
                val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                    putExtra("name", data.name)
                    putExtra("introduction", data.introduction)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                startActivity(intent)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}