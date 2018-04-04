package com.example.bartusis.petras.newsapp.main.main.newsList

import android.util.Log
import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenterImplemetation
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NewsListPresenter : BasePresenterImplemetation<NewsListContract.View>(),
        NewsListContract.Presenter {
    override fun getNewsList() {
        val url = "https://newsapi.org/v2/"
        val service = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(NewsApi::class.java)

        service.getArticles().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({news -> onView { showSuccess() }},
                        {error -> Log.e("NewsApi: ", error.message)})
    }

    override fun onViewReady() {
        onView { showSuccess() }
    }

}