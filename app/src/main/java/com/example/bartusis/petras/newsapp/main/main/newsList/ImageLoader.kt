package com.example.bartusis.petras.newsapp.main.main.newsList

import android.view.WindowManager
import android.widget.ImageView

interface ImageLoader {
    fun load(url: String, imageView: ImageView)
    fun loadFullImage(url: String, imageView: ImageView, windowManager: WindowManager)
}