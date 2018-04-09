package com.example.bartusis.petras.newsapp.main.main.news.list

import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenter
import com.example.bartusis.petras.newsapp.main.main.news.Article
import com.example.bartusis.petras.newsapp.main.main.news.News
import io.reactivex.Observable

interface NewsListContract {
    interface View {
        fun setNewsItems(news: News)
        fun setNewsItemsFromSharedPreferences()
        fun showError(message: Int)
        fun startDetailsActivity(article: Article)
        fun stopRefreshing()
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady()
        fun onSwipeLayoutRefresh()
        fun onArticleClicked(article: Article)
    }

    interface Model {
        fun getNews(): Observable<News>
        fun getCachedNews(): News
        fun saveNews(news: News)    }
}