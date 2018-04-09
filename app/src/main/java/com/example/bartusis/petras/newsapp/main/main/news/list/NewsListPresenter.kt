package com.example.bartusis.petras.newsapp.main.main.news.list

import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenterImplemetation
import com.example.bartusis.petras.newsapp.main.main.news.Article
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposables

class NewsListPresenter(
        private val model: NewsListContract.Model,
        private val newThread: Scheduler,
        private val mainThread: Scheduler
) : BasePresenterImplemetation<NewsListContract.View>(),
        NewsListContract.Presenter {
    private var disposable = Disposables.disposed()

    override fun onViewReady() {
        getNews()
    }

    private fun getNews(){
        disposable = model.getNews()
                .subscribeOn(newThread)
                .observeOn(mainThread)
                .subscribe({ news ->
                    model.saveNews(news)
                    onView { setNewsItems(news) }
                }, {
                    onView { setNewsItems(model.getCachedNews()) }
                })
    }

    override fun onSwipeLayoutRefresh() {
        getNews()
        onView { stopRefreshing() }
    }

    override fun onArticleClicked(article: Article) {
        onView { startDetailsActivity(article) }
    }

    override fun dropView() {
        disposable.dispose()
        super.dropView()
    }
}