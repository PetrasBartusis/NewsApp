package com.example.bartusis.petras.newsapp.main.main.newsList

class NewsListModel(private val newsApi: NewsApi) : NewsListContract.Model{
    override fun getNews() = newsApi.getArticles()
}