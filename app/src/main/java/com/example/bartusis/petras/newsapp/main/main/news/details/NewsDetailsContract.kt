package com.example.bartusis.petras.newsapp.main.main.news.details

import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenter
import com.example.bartusis.petras.newsapp.main.main.news.Article

interface NewsDetailsContract {
    interface View {
        fun setArticleTitle(title: String)
        fun setArticleDescription(description: String)
        fun setArticleAuthor(author: String)
        fun setArticleDate(date: String)
        fun setArticleImage(imageUrl: String)
        fun openBrowserWithUrl(url: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady()
        fun onArticleButtonClicked()
    }

    interface Model {
        fun getArticle() : Article
    }
}