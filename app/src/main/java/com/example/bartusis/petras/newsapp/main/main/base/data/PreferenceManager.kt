package com.example.bartusis.petras.newsapp.main.main.base.data

import com.example.bartusis.petras.newsapp.main.main.newsList.Article
import com.example.bartusis.petras.newsapp.main.main.newsList.News

interface PreferenceManager {
    fun getNews() : News
    fun setNews(news: News)
    fun getArticles() : List<Article>
}