package com.example.bartusis.petras.newsapp.main.main.news.list

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.BaseApplication
import com.example.bartusis.petras.newsapp.main.main.base.BaseFragment
import com.example.bartusis.petras.newsapp.main.main.base.DateFormatterImpl
import com.example.bartusis.petras.newsapp.main.main.base.data.dependencyRetriever
import com.example.bartusis.petras.newsapp.main.main.news.Article
import com.example.bartusis.petras.newsapp.main.main.news.News
import com.example.bartusis.petras.newsapp.main.main.news.PicassoImageLoader
import com.example.bartusis.petras.newsapp.main.main.news.details.NewsDetailsActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import java.io.Serializable

class NewsListFragment : BaseFragment(), NewsListContract.View, SwipeRefreshLayout.OnRefreshListener {
    private lateinit var presenter: NewsListContract.Presenter

    private var articleAdapter: ArticleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpPresenter()
    }

    private fun setUpPresenter(){
        val dependencyRetriever = context.dependencyRetriever
        presenter = NewsListPresenter(
                NewsListModel(dependencyRetriever.service, dependencyRetriever.sharedPreferences),
                Schedulers.io(),
                AndroidSchedulers.mainThread()
        )
        presenter.takeView(this)
    }

    private fun setUpAdapter() {
        articleAdapter = ArticleAdapter(
                PicassoImageLoader(), object : OnArticleClickListener {
            override fun onArticleClicked(article: Article) {
                presenter.onArticleClicked(article)
            }
        },
                DateFormatterImpl()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        presenter.onViewReady()
        refresh_layout.setOnRefreshListener(this)
        list.layoutManager = LinearLayoutManager(activity)
        list.adapter = articleAdapter
    }

    override fun onDestroyView() {
        presenter.dropView()
        super.onDestroyView()
    }

    override fun setNewsItems(news: News) {
        articleAdapter?.setItems(news.articles)
        (context.applicationContext as BaseApplication)
                .dependencyRetriever!!.sharedPreferences.setNews(news)
    }

    override fun onRefresh() {
        refresh_layout.isRefreshing = true
        presenter.onSwipeLayoutRefresh()
    }

    override fun stopRefreshing() {
        refresh_layout.isRefreshing = false
    }

    override fun setNewsItemsFromSharedPreferences() {
        articleAdapter?.setItems((context.applicationContext as BaseApplication)
                .dependencyRetriever!!.sharedPreferences.getNews().articles)
    }

    override fun showError(message: Int) {
        Toast.makeText(context, getString(message), Toast.LENGTH_SHORT).show()
    }

    override fun startDetailsActivity(article: Article) {
        startActivity(NewsDetailsActivity.createIntent(activity, article).putExtra(
                KEY_ARTICLE, article as Serializable
        ))
    }

    override fun layoutRes() = R.layout.fragment_main

    companion object {
        const val KEY_ARTICLE = "key.article"

        fun newInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}