package com.example.bartusis.petras.newsapp.main.main.newsList

import android.widget.ImageView

interface ImageLoader {
    fun load(url: String, imageView: ImageView)
}