package com.example.bartusis.petras.newsapp.main.main.newsList

import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenterImplemetation

class NewsListPresenter : BasePresenterImplemetation<NewsListContract.View>(),
        NewsListContract.Presenter {
    override fun onViewReady() {
        onView { showSuccess() }
    }

}