package com.example.bartusis.petras.newsapp.main.main.newsList

import android.util.Log

class GlideImageLoader : ImageLoader{
    override fun load(url: String) {
        Log.e("GlideImageLoader: ", "load image method")
    }

}