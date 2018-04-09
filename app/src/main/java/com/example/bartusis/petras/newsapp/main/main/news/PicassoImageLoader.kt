package com.example.bartusis.petras.newsapp.main.main.news

import android.widget.ImageView
import com.squareup.picasso.Picasso
import android.graphics.Point
import android.view.WindowManager
import com.example.bartusis.petras.newsapp.main.main.news.list.ImageLoader

class PicassoImageLoader : ImageLoader {

    override fun loadFullImage(url: String, imageView: ImageView, windowManager: WindowManager) {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        Picasso.get().load(url).resize(size.x, size.y/2).into(imageView)
    }

    override fun load(url: String, imageView: ImageView) {
        Picasso.get().load(url).resize(240, 180).into(imageView)
    }
}