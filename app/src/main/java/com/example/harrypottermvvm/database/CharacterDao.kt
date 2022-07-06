package com.example.harrypottermvvm.database

import androidx.room.Dao
import androidx.room.Query
import com.example.harrypottermvvm.model.CharacterResponseItem

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CharacterResponseItem")
    fun getAll(): List<CharacterResponseItem>

    @Query("SELECT * FROM CharacterResponseItem WHERE house IN  (:characterHouses)")
    fun getAllByHouses(characterHouses: ArrayList<String>): List<CharacterResponseItem>
}