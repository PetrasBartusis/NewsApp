package com.example.bartusis.petras.newsapp.main.main.news.list

import com.example.bartusis.petras.newsapp.main.main.news.Article

interface OnArticleClickListener {
    fun onArticleClicked(article: Article)
}