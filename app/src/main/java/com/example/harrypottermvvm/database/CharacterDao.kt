package com.example.harrypottermvvm.database

import androidx.room.Dao
import androidx.room.Query
import com.example.harrypottermvvm.model.CharacterResponseItem

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character")
    fun getAll(): List<CharacterResponseItem>

    @Query("SELECT * FROM character WHERE house IN  (:characterHouses)")
    fun getAllByHouses(characterHouses: ArrayList<String>): List<CharacterResponseItem>
}