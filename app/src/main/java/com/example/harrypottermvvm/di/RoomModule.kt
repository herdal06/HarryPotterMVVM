package com.example.harrypottermvvm.di

import android.content.Context
import androidx.room.Room
import com.example.harrypottermvvm.database.CharacterDao
import com.example.harrypottermvvm.database.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val DATABASE_NAME = "HarryPotterCharacterDatabase"

@[Module InstallIn(SingletonComponent::class)]
object RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return Room.databaseBuilder(context, CharacterDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(
        db: CharacterDatabase
    ): CharacterDao = db.characterDao()
}