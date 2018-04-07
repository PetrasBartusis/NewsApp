package com.example.bartusis.petras.newsapp.main.main.base

import android.app.Application
import com.example.bartusis.petras.newsapp.main.main.newsList.NewsApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BaseApplication : Application(){
    val service = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NewsApi::class.java)
}