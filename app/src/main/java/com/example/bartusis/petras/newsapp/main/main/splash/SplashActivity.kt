package com.example.bartusis.petras.newsapp.main.main.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bartusis.petras.newsapp.R
import com.example.bartusis.petras.newsapp.main.main.newsList.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.SplashTheme)
        startActivity(MainActivity.createIntent(this))
        finish()
    }
}