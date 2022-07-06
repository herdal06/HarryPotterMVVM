package com.example.harrypottermvvm.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "character")
@Parcelize
data class CharacterResponseItem(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "actor")
    @SerializedName("actor")
    val actor: String?,
    @ColumnInfo(name = "image")
    @SerializedName("image")
    val image: String?,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String?,
    @ColumnInfo(name = "house")
    @SerializedName("house")
    val house: String?,
    @ColumnInfo(name = "gender")
    @SerializedName("gender")
    val gender: String?,
    @ColumnInfo(name = "yearOfBirth")
    @SerializedName("yearOfBirth")
    val yearOfBirth: String?,
    @ColumnInfo(name = "hairColour")
    @SerializedName("hairColour")
    val hairColor: String?,
    @ColumnInfo(name = "eyeColour")
    @SerializedName("eyeColour")
    val eyeColor: String?,
    @ColumnInfo(name = "wizard")
    @SerializedName("wizard")
    val wizard: Boolean?,
    @ColumnInfo(name = "alive")
    @SerializedName("alive")
    val alive: Boolean?,
) : Parcelable