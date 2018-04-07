package com.example.bartusis.petras.newsapp.main.main.newsList

import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenterImplemetation
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposables

class NewsListPresenter(
        private val newsListModel: NewsListModel,
        private val newThread: Scheduler,
        private val mainThread: Scheduler
) : BasePresenterImplemetation<NewsListContract.View>(),
        NewsListContract.Presenter {
    var disposable = Disposables.disposed()

    override fun onViewReady() {
        disposable = newsListModel.newsObservable
                .subscribeOn(newThread)
                .observeOn(mainThread)
                .subscribe({ news -> onView { setNewsItems(news) } },
                        { error -> onView { showError(R.string.news_api_error) } })
    }

    override fun dropView() {
        disposable.dispose()
        super.dropView()
    }
}