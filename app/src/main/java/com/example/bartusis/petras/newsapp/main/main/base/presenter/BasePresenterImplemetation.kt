package com.example.bartusis.petras.newsapp.main.main.base.presenter

open class BasePresenterImplemetation<V> : BasePresenter<V> {
    private var view: V? = null

    override fun dropView() {
        view = null
    }

    override fun takeView(view: V) {
        this.view = view
    }

    fun onView(action: V.() -> Unit) {
        view?.let { action.invoke(it) }
    }
}