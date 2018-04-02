package com.example.bartusis.petras.newsapp.main.main.newsList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.BaseActivity

class NewsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            openFragment(NewsListFragment.newInstance(), false)
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, NewsListActivity::class.java)
    }
}
