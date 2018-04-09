package com.example.bartusis.petras.newsapp.main.main.newsDetails

import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenterImplemetation

class NewsDetailsPresenter(model: NewsDetailsContract.Model) : BasePresenterImplemetation<NewsDetailsContract.View>(),
        NewsDetailsContract.Presenter {
    override fun onViewReady() {
        onView { model.setArticleData() }
    }

}