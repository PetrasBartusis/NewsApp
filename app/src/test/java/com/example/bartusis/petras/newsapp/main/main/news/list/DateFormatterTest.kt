package com.example.bartusis.petras.newsapp.main.main.news.list

import com.example.bartusis.petras.newsapp.main.main.base.DateFormatterImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.text.ParseException

class DateFormatterTest {
    private lateinit var formatter: DateFormatterImpl

    @Before
    fun setUp() {
        formatter = DateFormatterImpl()
    }

    @Test
    fun format_emptyDate_emptyString() {
        val expected = ""

        val result = formatter.format("")

        Assert.assertEquals(expected, result)
    }

    @Test
    fun format_correctDate_formatsCorrectly() {
        val expected = "2018-April-08 07:25"

        val result = formatter.format("2018-04-08T07:25:00Z")

        Assert.assertEquals(expected, result)
    }

    @Test (expected = ParseException::class)
    fun format_wrongDate_throwsParseException() {
        formatter.format("2018test-04-08T07:25:00Z")
    }
}