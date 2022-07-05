package com.example.harrypottermvvm.repository

import com.example.harrypottermvvm.api.ApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getCharacter() = apiService.getCharacter()
}