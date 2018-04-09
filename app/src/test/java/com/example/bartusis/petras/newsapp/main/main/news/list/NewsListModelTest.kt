package com.example.bartusis.petras.newsapp.main.main.news.list

import com.example.bartusis.petras.newsapp.main.main.base.data.PreferenceManager
import com.example.bartusis.petras.newsapp.main.main.news.Article
import com.example.bartusis.petras.newsapp.main.main.news.News
import com.example.bartusis.petras.newsapp.main.main.news.Source
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import java.net.URL

class NewsListModelTest {
    private val newsApi = Mockito.mock(NewsApi::class.java)
    private val preferenceManager = Mockito.mock(PreferenceManager::class.java)
    val testNews = News("ok", 1, listOf(Article(
            Source("1", "test_name"),
            null,
            "test_title",
            "test_description",
            URL("http://www.test.com"),
            URL("http://www.test.com/image"),
            "2018-04-08T07:25:00Z"))
    )
    private lateinit var model: NewsListModel

    @Before
    fun setUp() {
        model = NewsListModel(newsApi, preferenceManager)
    }

    @Test
    fun getNews_getNewsFromApi() {
        val testArticle = News("ok", 1, listOf(Article(
                Source("1", "test_name"),
                null,
                "test_title",
                "test_description",
                URL("http://www.test.com"),
                URL("http://www.test.com/image"),
                "2018-04-08T07:25:00Z"))
        )
        val expected = Observable.just(testArticle)
        Mockito.`when`(newsApi.getArticles()).thenReturn(expected)

        val result = model.getNews()

        Assert.assertEquals(expected, result)
    }

    @Test
    fun getCachedNews_getNewsFromCache() {
        val expected = testNews
        Mockito.`when`(preferenceManager.getNews()).thenReturn(expected)

        val result = model.getCachedNews()

        Assert.assertEquals(expected, result)
    }

    @Test
    fun saveNews_saveNewsToPreferences() {
        model.saveNews(testNews)

        verify(preferenceManager).setNews(testNews)
    }
}