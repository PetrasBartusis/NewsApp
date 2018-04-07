package com.example.bartusis.petras.newsapp.main.main.base.data

import android.content.Context

class DependencyRetriever(private val context: Context) {
    val sharedPreferences by lazy {
        PreferenceData(context)
    }
}