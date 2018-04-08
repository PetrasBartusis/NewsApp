package com.example.bartusis.petras.newsapp.main.main.newsDetails

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.BaseFragment
import com.example.bartusis.petras.newsapp.main.main.newsList.Article
import com.example.bartusis.petras.newsapp.main.main.newsList.GlideImageLoader
import kotlinx.android.synthetic.main.fragment_details.*
import android.content.Intent
import android.net.Uri
import com.example.bartusis.petras.newsapp.main.main.base.BaseApplication

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
    }

    override fun setArticleData() {
        val article = arguments.getSerializable(Article.ARTICLE) as Article
        GlideImageLoader().loadFullImage(article.urlToImage.toString(), top_image, activity.windowManager)
        setArticleText(article)
        article_link_btn.setOnClickListener { openBrowserWithUrl(article)}
    }

    private fun openBrowserWithUrl(article: Article){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url.toString()))
        startActivity(browserIntent)
    }

    private fun setArticleText(article: Article){
        article_title.text = article.title
        article_description.text = article.description
        article_author.text = article.author
        article_date.text = (context.applicationContext as BaseApplication).
                dependencyRetriever!!.dateFormatter.format(article.publishedAt)
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