package com.example.bartusis.petras.newsapp.main.main.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.bartusis.petras.newsapp.R

open class BaseActivity : AppCompatActivity() {
    fun openFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment, fragment.javaClass.name)

        if (addToBackStack) {
            transaction.addToBackStack(fragment.javaClass.name)
        }
        transaction.commit()
    }
}