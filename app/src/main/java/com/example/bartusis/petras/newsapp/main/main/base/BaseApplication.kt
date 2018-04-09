package com.example.bartusis.petras.newsapp.main.main.base

import android.app.Application
import com.example.bartusis.petras.newsapp.main.main.base.data.DependencyRetriever

class BaseApplication : Application(){
    var dependencyRetriever : DependencyRetriever? = null
    override fun onCreate() {
        super.onCreate()
        dependencyRetriever = DependencyRetriever(this)
    }
}