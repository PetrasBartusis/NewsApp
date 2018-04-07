package com.example.bartusis.petras.newsapp.main.main.newsList

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.BaseApplication
import com.example.bartusis.petras.newsapp.main.main.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*

class NewsListFragment : BaseFragment(), NewsListContract.View {

    private lateinit var presenter: NewsListContract.Presenter

    private var articleAdapter: ArticleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = NewsListPresenter(
                NewsListModel((context.applicationContext as BaseApplication).service!!),
                (context.applicationContext as BaseApplication)
                        .dependencyRetriever!!
                        .sharedPreferences,
                Schedulers.io(),
                AndroidSchedulers.mainThread()
        )
        articleAdapter = ArticleAdapter(GlideImageLoader())
        presenter.takeView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewReady()
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

    override fun setNewsItemsFromSharedPreferences() {
        articleAdapter?.setItems((context.applicationContext as BaseApplication)
                    .dependencyRetriever!!.sharedPreferences.getNews().articles)
    }

    override fun showError(message: Int) {
        Toast.makeText(context, getString(message), Toast.LENGTH_SHORT).show()
    }

    override fun layoutRes() = R.layout.fragment_main

    companion object {
        fun newInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}