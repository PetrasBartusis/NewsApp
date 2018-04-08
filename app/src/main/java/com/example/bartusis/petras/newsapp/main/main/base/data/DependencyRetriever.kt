package com.example.bartusis.petras.newsapp.main.main.base.data

import android.content.Context
import com.example.bartusis.petras.newsapp.main.main.base.DateFormatterImpl

class DependencyRetriever(private val context: Context) {
    val sharedPreferences by lazy {
        PreferenceData(context)
    }
    val dateFormatter by lazy {
        DateFormatterImpl()
    }
}