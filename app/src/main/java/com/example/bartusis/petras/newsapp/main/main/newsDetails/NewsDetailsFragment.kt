package com.example.bartusis.petras.newsapp.main.main.newsDetails

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.BaseFragment
import com.example.bartusis.petras.newsapp.main.main.newsList.Article
import com.example.bartusis.petras.newsapp.main.main.newsList.GlideImageLoader
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*

class NewsDetailsFragment : BaseFragment(), NewsDetailsContract.View {

    private lateinit var presenter: NewsDetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = NewsDetailsPresenter()
        presenter.takeView(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewReady()
        val article = arguments.getSerializable(Article.ARTICLE) as Article
        Picasso.get().load(article.urlToImage.toString()).into(top_image as ImageView)
    }

    override fun onDestroyView() {
        presenter.dropView()
        super.onDestroyView()
    }

    override fun layoutRes() = R.layout.fragment_details

    companion object {
        fun newInstance(): NewsDetailsFragment {
            return NewsDetailsFragment()
        }
    }
}