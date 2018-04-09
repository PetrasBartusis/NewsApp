package com.example.bartusis.petras.newsapp.main.main.news.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.bartusis.petras.newsapp.main.main.base.DateFormatter
import com.example.bartusis.petras.newsapp.main.main.news.Article
import kotlinx.android.synthetic.main.article_list_item.view.*

class ArticleViewHolder(
        itemView: View,
        private val imageLoader: ImageLoader,
        private val listener: OnArticleClickListener,
        private val dateFormatter: DateFormatter
) : RecyclerView.ViewHolder(itemView) {
    fun bind(article: Article) {
        itemView.setOnClickListener {
            listener.onArticleClicked(article)
        }
        if(article.urlToImage!=null){
            imageLoader.load(article.urlToImage.toString(), itemView.image)
        }
        itemView.text_view.text = article.title
        itemView.date_view.text = dateFormatter.format(article.publishedAt)
    }
}