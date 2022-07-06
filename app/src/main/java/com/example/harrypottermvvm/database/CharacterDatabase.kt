package com.example.harrypottermvvm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.harrypottermvvm.model.CharacterResponseItem

@Database(entities = [CharacterResponseItem::class], version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}