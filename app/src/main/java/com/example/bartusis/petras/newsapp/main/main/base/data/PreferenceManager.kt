package com.example.bartusis.petras.newsapp.main.main.base.data

import com.example.bartusis.petras.newsapp.main.main.news.Article
import com.example.bartusis.petras.newsapp.main.main.news.News

interface PreferenceManager {
    fun getNews() : News
    fun setNews(news: News)
    fun getArticles() : List<Article>
}