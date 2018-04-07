package com.example.bartusis.petras.newsapp.main.main.newsList

import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenter

interface NewsListContract {
    interface View {
        fun setNewsItems(news: News)
        fun showError(message: Int)
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady()
    }
}