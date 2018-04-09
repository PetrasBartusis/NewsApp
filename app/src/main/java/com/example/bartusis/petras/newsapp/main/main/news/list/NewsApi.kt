package com.example.bartusis.petras.newsapp.main.main.news.list

import com.example.bartusis.petras.newsapp.main.main.news.News
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsApi {

    @GET("top-headlines?country=us&apiKey=57a79eac5a8f44efa2bd3408139b83f3")
    fun getArticles(): Observable<News>
}