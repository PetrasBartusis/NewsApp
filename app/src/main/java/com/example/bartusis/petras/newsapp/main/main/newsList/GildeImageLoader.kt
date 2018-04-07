package com.example.bartusis.petras.newsapp.main.main.newsList

import android.widget.ImageView
import com.squareup.picasso.Picasso

class GlideImageLoader : ImageLoader {

    override fun load(url: String, imageView: ImageView) {
        Picasso.get().load(url).resize(240, 160).into(imageView)
    }

}