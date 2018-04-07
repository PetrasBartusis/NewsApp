package com.example.bartusis.petras.newsapp.main.main.newsList

class NewsListModel(newsApi: NewsApi){
    val newsObservable = newsApi.getArticles()
}