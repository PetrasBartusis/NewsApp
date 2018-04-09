package com.example.bartusis.petras.newsapp.main.main.news.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.BaseActivity
import com.example.bartusis.petras.newsapp.main.main.news.Article

class NewsDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        openFragment()
    }

    private fun openFragment() {
        val article = intent.getSerializableExtra(KEY_ARTICLE) as Article
        val fragment = NewsDetailsFragment.newInstance(article)
        openFragment(fragment, false)
    }

    companion object {
        private const val KEY_ARTICLE = "key.article"

        fun createIntent(context: Context, article: Article): Intent {
            return Intent(context, NewsDetailsActivity::class.java).putExtra(KEY_ARTICLE, article)
        }
    }
}