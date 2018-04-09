package com.example.bartusis.petras.newsapp.main.main.base.data

import android.content.Context
import com.example.bartusis.petras.newsapp.main.main.news.News
import com.google.gson.Gson

class PreferenceData(private val context: Context) : PreferenceManager {
    override fun setNews(news: News) {
        with(sharedPreferences.edit()) {
            putString(NEWS, gson.toJson(news))
            apply()
        }
    }

    override fun getNews(): News {
        val newsData = sharedPreferences.getString(NEWS, "")
        if (newsData.isNullOrEmpty()) {
            return News("", 0, emptyList())
        }
        return gson.fromJson(sharedPreferences.getString(NEWS, ""),
                News::class.java)
    }

    override fun getArticles() = getNews().articles

    private val gson by lazy {
        Gson()
    }

    private val sharedPreferences by lazy {
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    companion object {
        const val NEWS = "NEWS"
    }

}