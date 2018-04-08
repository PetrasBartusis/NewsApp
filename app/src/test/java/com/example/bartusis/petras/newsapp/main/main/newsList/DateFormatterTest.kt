package com.example.bartusis.petras.newsapp.main.main.newsList

import com.example.bartusis.petras.newsapp.main.main.base.DateFormatterImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DateFormatterTest {
    private lateinit var formatter: DateFormatterImpl

    @Before
    fun setUp() {
        formatter = DateFormatterImpl()
    }

    @Test
    fun testEmptyDate() {
        val expected = ""

        val result = formatter.format("")

        Assert.assertEquals(expected, result)
    }

    @Test
    fun testDate() {
        val expected = "2018-April-08 07:25"

        val result = formatter.format("2018-04-08T07:25:00Z")

        Assert.assertEquals(expected, result)
    }
}