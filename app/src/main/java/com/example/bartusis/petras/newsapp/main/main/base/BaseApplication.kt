package com.example.bartusis.petras.newsapp.main.main.base

import android.app.Application
import com.example.bartusis.petras.newsapp.BuildConfig
import com.example.bartusis.petras.newsapp.main.main.base.data.DependencyRetriever
import com.example.bartusis.petras.newsapp.main.main.newsList.NewsApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BaseApplication : Application(){
    var service : NewsApi? = null
    var dependencyRetriever : DependencyRetriever? = null
    override fun onCreate() {
        super.onCreate()
        dependencyRetriever = DependencyRetriever(this)
        service = Retrofit.Builder()
                .baseUrl(BuildConfig.NEWS_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(NewsApi::class.java)!!
    }
}