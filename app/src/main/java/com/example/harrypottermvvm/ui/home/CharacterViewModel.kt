package com.example.harrypottermvvm.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypottermvvm.model.CharacterResponseItem
import com.example.harrypottermvvm.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {
    private val _response = MutableLiveData<List<CharacterResponseItem>>()
    val characterResponse: LiveData<List<CharacterResponseItem>>
        get() = _response

    init {
        getCharacter()
        getGryffindorCharacters()
    }

    private fun getCharacter() = viewModelScope.launch {
        repository.getCharacter().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("Response Error", "getCharacter: ${response.code()}")
            }
        }
    }
    private fun getGryffindorCharacters() = viewModelScope.launch {
        repository.getGryffindorCharacters().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("Response Error", "getGryffindorCharacters: ${response.code()}")
            }
        }
    }
}