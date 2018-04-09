package com.example.bartusis.petras.newsapp.main.main.news.details

import com.example.bartusis.petras.newsapp.main.main.news.Article

interface ArticleProvider {
    fun getArticle() : Article

}