package com.example.bartusis.petras.newsapp.main.main.newsList

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.BaseFragment

class NewsListFragment : BaseFragment(), NewsListContract.View {
    private lateinit var presenter: NewsListContract.Presenter

    override fun layoutRes() = R.layout.fragment_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = NewsListPresenter()
        presenter.takeView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewReady()
    }

    override fun onDestroyView() {
        presenter.dropView()
        super.onDestroyView()
    }

    override fun showSuccess() {
        Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}