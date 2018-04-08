package com.example.bartusis.petras.newsapp.main.main.newsList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.base.DateFormatter

class ArticleAdapter (
        private val imageLoader: ImageLoader,
        private val listener: OnArticleClickListener,
        private val dateFormatter: DateFormatter
) : RecyclerView.Adapter<ArticleViewHolder>() {
    private val list = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.article_list_item, parent, false)
        return ArticleViewHolder(itemView, imageLoader, listener, dateFormatter)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(articles: List<Article>) {
        list.clear()
        list.addAll(articles)
        notifyDataSetChanged()
    }
}
