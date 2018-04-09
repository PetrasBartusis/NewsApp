package com.example.bartusis.petras.newsapp.main.main.news.details

import android.os.Bundle
import android.view.View
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.BaseFragment
import com.example.bartusis.petras.newsapp.main.main.news.Article
import kotlinx.android.synthetic.main.fragment_details.*
import android.content.Intent
import android.net.Uri
import com.example.bartusis.petras.newsapp.main.main.base.DateFormatterImpl
import com.example.bartusis.petras.newsapp.main.main.news.PicassoImageLoader

class NewsDetailsFragment : BaseFragment(), NewsDetailsContract.View, ArticleProvider {
    override fun setArticleImage(imageUrl: String) {
        PicassoImageLoader().loadFullImage(
                imageUrl,
                top_image,
                activity.windowManager)
    }

    override fun setArticleTitle(title: String) {
        article_title.text = title

    }

    override fun setArticleDescription(description: String) {
        article_description.text = description
    }

    override fun setArticleAuthor(author: String) {
        article_author.text = author
    }

    override fun setArticleDate(date: String) {
        article_date.text = date
    }

    override fun getArticle(): Article {
        return arguments!!.getSerializable(KEY_ARTICLE) as Article
    }

    private lateinit var presenter: NewsDetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpPresenter()
    }

    private fun setUpPresenter() {
        val model = NewsDetailsModel(this)
        presenter = NewsDetailsPresenter(model, DateFormatterImpl())
        presenter.takeView(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewReady()
        setOnClickListeners()
    }

    override fun openBrowserWithUrl(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    private fun setOnClickListeners() {
        article_link_btn.setOnClickListener { presenter.onArticleButtonClicked() }
    }

    override fun onDestroyView() {
        presenter.dropView()
        super.onDestroyView()
    }

    override fun layoutRes() = R.layout.fragment_details

    companion object {
        private const val KEY_ARTICLE = "key.article"

        fun newInstance(article: Article): NewsDetailsFragment { // TODO create bundle and set arguments here
            val fragment = NewsDetailsFragment()
            val bundle = Bundle()
            bundle.putSerializable(KEY_ARTICLE, article)
            fragment.arguments = bundle
            return fragment
        }
    }
}