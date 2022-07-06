package com.example.harrypottermvvm.database

import javax.inject.Inject


class CharacterRepository @Inject constructor(
    private val dbDao: CharacterDao
) {
    fun getAllCharacters() = dbDao.getAll()
}