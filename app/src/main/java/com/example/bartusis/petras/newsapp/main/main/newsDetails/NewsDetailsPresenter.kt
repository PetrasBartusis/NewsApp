package com.example.bartusis.petras.newsapp.main.main.newsDetails

import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenterImplemetation

class NewsDetailsPresenter : BasePresenterImplemetation<NewsDetailsContract.View>(),
        NewsDetailsContract.Presenter {
    override fun onViewReady() {
        onView { setArticleData() }
    }

}