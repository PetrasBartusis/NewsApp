package com.example.bartusis.petras.newsapp.main.main.news.details

import com.example.bartusis.petras.newsapp.main.main.base.DateFormatter
import com.example.bartusis.petras.newsapp.main.main.news.details.NewsDetailsContract
import com.example.bartusis.petras.newsapp.main.main.news.details.NewsDetailsPresenter
import com.example.bartusis.petras.newsapp.main.main.news.Article
import com.example.bartusis.petras.newsapp.main.main.news.Source
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import java.net.URL

class NewsDetailsTest {
    private val view = Mockito.mock(NewsDetailsContract.View::class.java)
    private val model = Mockito.mock(NewsDetailsContract.Model::class.java)
    private val dateFormatter = Mockito.mock(DateFormatter::class.java)
    private lateinit var presenter: NewsDetailsPresenter
    private val testArticle = Article(
            Source("1", "test_name"),
            "test_author",
            "test_title",
            "test_description",
            URL("http://www.test.com"),
            URL("http://www.test.com/image"),
            "2018-04-08T07:25:00Z"
    )

    @Before
    fun setUp() {
        presenter = NewsDetailsPresenter(model, dateFormatter)
        presenter.takeView(view)
    }

    @Test
    fun onViewReady_nonEmptyArticle_setArticleAuthor() {
        Mockito.`when`(model.getArticle()).thenReturn(testArticle)

        presenter.onViewReady()

        verify(view).setArticleAuthor(testArticle.author!!)
    }

    @Test
    fun onViewReady_nonEmptyArticle_setArticleAuthorNull() {
        val testArticle = Article(
                Source("1", "test_name"),
                null,
                "test_title",
                "test_description",
                URL("http://www.test.com"),
                URL("http://www.test.com/image"),
                "2018-04-08T07:25:00Z"
        )
        Mockito.`when`(model.getArticle()).thenReturn(testArticle)

        presenter.onViewReady()

        verify(view).setArticleAuthor("")
    }

    @Test
    fun onViewReady_nonEmptyArticle_setArticleDescription() {
        Mockito.`when`(model.getArticle()).thenReturn(testArticle)

        presenter.onViewReady()

        verify(view).setArticleDescription(testArticle.description)
    }

    @Test
    fun onViewReady_nonEmptyArticle_setArticleTitle() {
        Mockito.`when`(model.getArticle()).thenReturn(testArticle)

        presenter.onViewReady()

        verify(view).setArticleTitle(testArticle.title)
    }

    @Test
    fun onViewReady_nonEmptyArticle_setArticleDate() {
        val formattedDate = ""
        Mockito.`when`(model.getArticle()).thenReturn(testArticle)
        Mockito.`when`(dateFormatter.format(testArticle.publishedAt)).thenReturn(formattedDate)

        presenter.onViewReady()

        verify(view).setArticleDate(formattedDate)
    }

    @Test
    fun onViewReady_nonEmptyArticle_setArticleImage() {
        Mockito.`when`(model.getArticle()).thenReturn(testArticle)

        presenter.onViewReady()

        verify(view).setArticleImage(testArticle.urlToImage.toString())
    }

    @Test
    fun onArticleButtonClicked_openBrowser() {
        Mockito.`when`(model.getArticle()).thenReturn(testArticle)

        presenter.onArticleButtonClicked()

        verify(view).openBrowserWithUrl(testArticle.url.toString())
    }
}