package com.example.bartusis.petras.newsapp.main.main.newsDetails

import android.os.Bundle
import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenter
import com.example.bartusis.petras.newsapp.main.main.newsList.Article

interface NewsDetailsContract {
    interface View {
        fun setArticleData()
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady()
    }

    interface Model {
        fun getArticle(arguments: Bundle) : Article
    }
}