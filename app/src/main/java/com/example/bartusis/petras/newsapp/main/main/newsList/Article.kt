package com.example.bartusis.petras.newsapp.main.main.newsList

import org.json.JSONObject
import java.net.URL

data class Article(val source: JSONObject, val author: String, val title: String, val description: String,
                   val url: URL, val urlToImage: URL, val publishedAt: String)