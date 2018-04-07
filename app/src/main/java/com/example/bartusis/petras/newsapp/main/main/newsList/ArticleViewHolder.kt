package com.example.bartusis.petras.newsapp.main.main.newsList

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.article_list_item.view.*

class ArticleViewHolder(itemView: View, private val imageLoader: ImageLoader) : RecyclerView.ViewHolder(itemView) {
    fun bind(article: Article) {
        if(article.urlToImage!=null){
            imageLoader.load(article.urlToImage.toString(), itemView.image)
        }
        itemView.text_view.text = article.title
        itemView.date_view.text = article.publishedAt
    }
}