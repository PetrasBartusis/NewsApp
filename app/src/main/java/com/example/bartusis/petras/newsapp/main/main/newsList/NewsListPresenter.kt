package com.example.bartusis.petras.newsapp.main.main.newsList

import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.data.PreferenceManager
import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenterImplemetation
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposables

class NewsListPresenter(
        private val newsListModel: NewsListContract.Model,
        private val sharedPreferences: PreferenceManager,
        private val newThread: Scheduler,
        private val mainThread: Scheduler
) : BasePresenterImplemetation<NewsListContract.View>(),
        NewsListContract.Presenter {
    private var disposable = Disposables.disposed()

    override fun onViewReady() {
        getNews()
    }

    private fun getNews(){
        disposable = newsListModel.getNews()
                .subscribeOn(newThread)
                .observeOn(mainThread)
                .subscribe({ news -> onView { setNewsItems(news) } },
                        { onView { setNewsItemsFromSharedPreferences() } })
    }

    override fun dropView() {
        disposable.dispose()
        super.dropView()
    }
}