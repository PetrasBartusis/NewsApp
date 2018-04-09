package com.example.bartusis.petras.newsapp.main.main.news.details

import com.example.bartusis.petras.newsapp.main.main.news.Article
import com.example.bartusis.petras.newsapp.main.main.news.Source
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.net.URL

class NewsDetailsModelTest {
    private val provider = Mockito.mock(ArticleProvider::class.java)
    private lateinit var model: NewsDetailsModel

    @Before
    fun setUp() {
        model = NewsDetailsModel(provider)
    }

    @Test
    fun getArticles_getArticlesFromProvider() {
        val expected = Article(
                Source("1", "test_name"),
                null,
                "test_title",
                "test_description",
                URL("http://www.test.com"),
                URL("http://www.test.com/image"),
                "2018-04-08T07:25:00Z"
        )
        Mockito.`when`(provider.getArticle()).thenReturn(expected)

        val result = model.getArticle()

        Assert.assertEquals(expected, result)
    }
}