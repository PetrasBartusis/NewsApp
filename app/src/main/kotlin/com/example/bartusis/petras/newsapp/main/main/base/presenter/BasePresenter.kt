package com.example.bartusis.petras.newsapp.main.main.base.presenter

interface BasePresenter<in V> {
    fun takeView(view: V)

    fun dropView()
}