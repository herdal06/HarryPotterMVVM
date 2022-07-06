package com.example.harrypottermvvm.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.harrypottermvvm.R
import com.example.harrypottermvvm.adapter.CharacterAdapter
import com.example.harrypottermvvm.databinding.FragmentHomeBinding
import com.example.harrypottermvvm.utils.viewBinding
import com.example.harrypottermvvm.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var characterAdapter: CharacterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() = with(binding) {

        characterAdapter = CharacterAdapter()

        recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            adapter = characterAdapter
        }

        viewModel.characterResponse.observe(requireActivity()) {
            characterAdapter.character = it
        }
    }
}