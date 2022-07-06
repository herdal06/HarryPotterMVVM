package com.example.harrypottermvvm.utils

import android.widget.ImageView
import coil.load

fun ImageView.loadImage(url: String?) {
    this.load(url) {
        crossfade(true)
        crossfade(1000)
    }
}