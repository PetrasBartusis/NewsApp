package com.example.bartusis.petras.newsapp.main.main.news.list

import com.example.bartusis.petras.newsapp.main.main.base.data.PreferenceManager
import com.example.bartusis.petras.newsapp.main.main.news.News

class NewsListModel(
        private val newsApi: NewsApi,
        private val preferenceManager: PreferenceManager
) : NewsListContract.Model {
    override fun getCachedNews() = preferenceManager.getNews()

    override fun saveNews(news: News){
        preferenceManager.setNews(news)
    }
    override fun getNews() = newsApi.getArticles()
}