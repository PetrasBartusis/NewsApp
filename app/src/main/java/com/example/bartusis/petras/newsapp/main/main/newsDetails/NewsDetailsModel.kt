package com.example.bartusis.petras.newsapp.main.main.newsDetails

import android.os.Bundle
import com.example.bartusis.petras.newsapp.main.main.newsList.Article

class NewsDetailsModel : NewsDetailsContract.Model {
    override fun getArticle(arguments: Bundle): Article {
        val article = arguments.getSerializable(Article.ARTICLE) as Article
        return article
    }

}