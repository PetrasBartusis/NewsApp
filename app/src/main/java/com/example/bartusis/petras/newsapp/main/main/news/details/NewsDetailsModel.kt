package com.example.bartusis.petras.newsapp.main.main.news.details

import com.example.bartusis.petras.newsapp.main.main.news.Article

class NewsDetailsModel(private val articleProvider: ArticleProvider) : NewsDetailsContract.Model {
    override fun getArticle(): Article {
        return articleProvider.getArticle()
    }
}