package com.example.bartusis.petras.newsapp.main.main.newsList

import com.example.bartusis.petras.newsapp.main.main.newsDetails.NewsDetailsContract
import com.example.bartusis.petras.newsapp.main.main.newsDetails.NewsDetailsPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import java.net.URL

class NewsDetailsTest {
    private val view = Mockito.mock(NewsDetailsContract.View::class.java)
    private val model = Mockito.mock(NewsDetailsContract.Model::class.java)
    private lateinit var presenter: NewsDetailsPresenter

    @Before
    fun setUp() {
        presenter = NewsDetailsPresenter()
    }

    @Test
    fun onViewReady_setArticleData() {
        Mockito.`when`(model.getArticle()).thenReturn(
                Article(
                Source("1", "test_name"),
                "test_author",
                "test_title",
                "test_description",
                URL("http://www.test.com"),
                URL("http://www.test.com/image"),
                "2018-04-08T07:25:00Z"
            )
        )
        // act
        presenter.onViewReady()

        // assert
        verify(view).setArticleData()
    }
}