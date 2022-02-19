package com.example.firstandroid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstandroid.adapter.RepositoryAdapter
import com.example.firstandroid.data.RepositoryData
import com.example.firstandroid.databinding.FragmentRepositoryListBinding

class RepositoryListFragment : Fragment() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private var _binding: FragmentRepositoryListBinding? = null
    private val binding get() = _binding?: error("Binding이 초기화 되지 않았습니다")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryListBinding.inflate(layoutInflater, container, false)
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
        repositoryAdapter = RepositoryAdapter()
        binding.rvRepository.adapter = repositoryAdapter
        repositoryAdapter.repositoryList.addAll(
            listOf(
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                RepositoryData("가나다", "가나다라"),
                )
        )
        repositoryAdapter.notifyDataSetChanged()
    }

}