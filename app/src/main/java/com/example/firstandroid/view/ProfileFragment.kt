package com.example.firstandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firstandroid.R
import com.example.firstandroid.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {
    private var position = ProfileActivity.FOLLOWER_LIST_POSITION
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTransactionEvent()
        Glide.with(requireContext()).load("https://github.com/xxeol2.png").circleCrop().into(binding.ivProfile)
    }

    private fun initTransactionEvent() {
        val followerListFragment = FollowerListFragment()
        val repositoryListFragment = RepositoryListFragment()

        requireActivity().supportFragmentManager.beginTransaction().add(R.id.fragment_list, followerListFragment).commit()

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
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_list, fragment).commit()
        position = pos
    }

    companion object {
        const val FOLLOWER_LIST_POSITION = 1
        const val REPOSITORY_LIST_POSITION = 2
    }
}