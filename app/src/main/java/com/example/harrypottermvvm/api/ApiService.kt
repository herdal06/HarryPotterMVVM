package com.example.harrypottermvvm.api

import com.example.harrypottermvvm.model.CharacterResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/characters")
    suspend fun getCharacter(): Response<List<CharacterResponseItem>>

    @GET("api/characters/house/gryffindor")
    suspend fun getGryffindorCharacters(): Response<List<CharacterResponseItem>>

    @GET("api/characters/house/slytherin")
    suspend fun getSlytherinCharacters(): Response<List<CharacterResponseItem>>

    @GET("api/characters/house/hufflepuff")
    suspend fun getHufflepuffCharacters(): Response<List<CharacterResponseItem>>

    @GET("api/characters/house/ravenclaw")
    suspend fun getRavenclawCharacters(): Response<List<CharacterResponseItem>>
}