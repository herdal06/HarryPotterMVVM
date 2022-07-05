package com.example.harrypottermvvm.api

import com.example.harrypottermvvm.model.CharacterResponse
import com.example.harrypottermvvm.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getCharacters(): Response<CharacterResponse>
}