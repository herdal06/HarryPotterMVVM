package com.example.harrypottermvvm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterResponseItem(
    @SerializedName("actor")
    val actor: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("house")
    val house: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("yearOfBirth")
    val yearOfBirth: String?,
    @SerializedName("hairColor")
    val hairColor: String?,
    @SerializedName("eyeColor")
    val eyeColor: String?,
    @SerializedName("wizard")
    val wizard: Boolean?,
    @SerializedName("alive")
    val alive: Boolean?,
) : Parcelable