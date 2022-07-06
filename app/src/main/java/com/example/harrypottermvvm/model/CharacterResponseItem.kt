package com.example.harrypottermvvm.model

import com.google.gson.annotations.SerializedName

data class CharacterResponseItem(
    @SerializedName("actor")
    val actor: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,

)