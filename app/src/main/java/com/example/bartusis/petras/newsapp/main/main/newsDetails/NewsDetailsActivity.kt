package com.example.bartusis.petras.newsapp.main.main.newsDetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.BaseActivity
import com.example.bartusis.petras.newsapp.main.main.newsList.Article

class NewsDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.hide()
        if (savedInstanceState == null) {
            openFragment()
        }
    }

    private fun openFragment() {
        val bundle = Bundle()
        bundle.putSerializable(Article.ARTICLE, intent.extras.getSerializable(Article.ARTICLE))
        val fragment = NewsDetailsFragment.newInstance()
        fragment.arguments = bundle
        openFragment(fragment, false)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, NewsDetailsActivity::class.java)
    }
}