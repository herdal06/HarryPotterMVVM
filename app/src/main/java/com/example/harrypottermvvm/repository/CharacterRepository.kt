package com.example.harrypottermvvm.repository

import com.example.harrypottermvvm.api.ApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getCharacter() = apiService.getCharacter()
    suspend fun getGryffindorCharacters() = apiService.getGryffindorCharacters()
    suspend fun getSlytherinCharacters() = apiService.getSlytherinCharacters()
    suspend fun getHufflepuffCharacters() = apiService.getHufflepuffCharacters()
    suspend fun getRavenclawCharacters() = apiService.getRavenclawCharacters()
}