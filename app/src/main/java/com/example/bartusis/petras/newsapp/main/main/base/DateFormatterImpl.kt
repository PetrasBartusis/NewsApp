package com.example.bartusis.petras.newsapp.main.main.base

import java.text.SimpleDateFormat
import java.util.*

class DateFormatterImpl : DateFormatter {
    private val baseFormat = SimpleDateFormat("yyyy-MMMM-dd HH:mm", Locale.ROOT)
    var givenFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT)

    override fun format(dateToFormat: String) : String{
        val date = givenFormat.parse(dateToFormat)
        return baseFormat.format(date)
    }
}