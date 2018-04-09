package com.example.bartusis.petras.newsapp.main.main.news.details

import com.example.bartusis.petras.newsapp.main.main.base.DateFormatter
import com.example.bartusis.petras.newsapp.main.main.base.presenter.BasePresenterImplemetation

class NewsDetailsPresenter(
        private val model: NewsDetailsContract.Model,
        private val dateFormatter: DateFormatter
) : BasePresenterImplemetation<NewsDetailsContract.View>(),
        NewsDetailsContract.Presenter {
    override fun onArticleButtonClicked() {
        onView { openBrowserWithUrl(model.getArticle().url.toString()) }
    }

    override fun onViewReady() {
        val article = model.getArticle()
        onView {

            setArticleTitle(article.title)
            setArticleImage(article.urlToImage.toString())
            setArticleAuthor(article.author?:"")
            setArticleDate(dateFormatter.format(article.publishedAt))
            setArticleDescription(article.description)
        }

    }
}