package com.example.bartusis.petras.newsapp.main.main.base.data

import android.content.Context
import com.example.bartusis.petras.newsapp.BuildConfig
import com.example.bartusis.petras.newsapp.main.main.base.BaseApplication
import com.example.bartusis.petras.newsapp.main.main.news.list.NewsApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DependencyRetriever(private val context: Context) {
    val sharedPreferences by lazy {
        PreferenceData(context)
    }
    val service by lazy {
        Retrofit.Builder()
                .baseUrl(BuildConfig.NEWS_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(NewsApi::class.java)!!
    }
}
val Context.dependencyRetriever: DependencyRetriever get() = (applicationContext as BaseApplication).dependencyRetriever!!