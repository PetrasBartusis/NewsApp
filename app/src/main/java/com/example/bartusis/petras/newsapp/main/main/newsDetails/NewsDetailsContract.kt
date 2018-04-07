package com.example.bartusis.petras.newsapp.main.main.newsDetails

import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenter

interface NewsDetailsContract {
    interface View {
        fun setArticleData()
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady()
    }

}