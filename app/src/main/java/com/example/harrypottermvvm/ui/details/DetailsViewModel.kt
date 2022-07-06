package com.example.harrypottermvvm.ui.details

import androidx.lifecycle.ViewModel
import com.example.harrypottermvvm.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {
}