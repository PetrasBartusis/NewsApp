package com.example.bartusis.petras.newsapp.main.main.newsList

import android.widget.ImageView
import com.squareup.picasso.Picasso
import android.graphics.Point
import android.view.WindowManager

class GlideImageLoader : ImageLoader {

    override fun loadFullImage(url: String, imageView: ImageView, windowManager: WindowManager) {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        Picasso.get().load(url).resize(size.x, size.y/2).into(imageView)
    }

    override fun load(url: String, imageView: ImageView) {
        Picasso.get().load(url).resize(240, 160).into(imageView)
    }

}