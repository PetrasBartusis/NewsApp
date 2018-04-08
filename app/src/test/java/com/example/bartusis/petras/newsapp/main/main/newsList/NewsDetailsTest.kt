package com.example.bartusis.petras.newsapp.main.main.newsList

import com.example.bartusis.petras.newsapp.main.main.newsDetails.NewsDetailsContract
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class NewsDetailsTest {
    private val view = Mockito.mock(NewsDetailsContract.View::class.java)
    private lateinit var presenter: NewsListPresenter

    @Before
    fun setUp() {
//        presenter = NewsListPresenter()
    }

    @Test
    fun onViewReady_bulveIsSkani_viewThanksPetras() {
        // assign
        val bulviuKose = BulviuKose(true)
        //Mockito.`when`(model.getBulviuKose()).thenReturn(bulviuKose)

        // act
        presenter.onViewReady()

        // assert
        //verify(view).thankPetras()
    }

    @Test
    fun onViewReady_bulveIsNotSkani_viewThanksPetras() {
        // assign
        val bulviuKose = BulviuKose(false)
        //Mockito.`when`(model.getBulviuKose()).thenReturn(bulviuKose)

        // act
        presenter.onViewReady()

        // assert
        //verify(view).petrasyouliedtousaboutbulviukose()
        //verify(view, never()).thankPetras()
    }
}