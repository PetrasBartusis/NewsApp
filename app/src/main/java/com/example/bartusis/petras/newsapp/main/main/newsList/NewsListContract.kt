package com.example.bartusis.petras.newsapp.main.main.newsList

import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenter
import io.reactivex.Observable

interface NewsListContract {
    interface View {
        fun setNewsItems(news: News)
        fun setNewsItemsFromSharedPreferences()
        fun showError(message: Int)
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady()
    }

    interface Model {
        fun getNews() : Observable<News>
    }
}