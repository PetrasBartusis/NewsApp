package com.example.bartusis.petras.newsapp.main.main.newsList

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.never
import org.mockito.Mockito.verify

class NewsListPresenterTest {
    private val view = Mockito.mock(NewsListContract.View::class.java)
    private val model = Mockito.mock(NewsListContract.Model::class.java)
    private lateinit var presenter: NewsListPresenter

    @Before
    fun setUp() {

    }

    @Test
    fun onViewReady_bulveIsSkani_viewThanksPetras() {
        // assign
        //Mockito.`when`(model.getBulviuKose()).thenReturn(bulviuKose)

        // act
        presenter.onViewReady()

        // assert
        //verify(view).thankPetras()
    }

    @Test
    fun onViewReady_bulveIsNotSkani_viewThanksPetras() {
        // assign
        //Mockito.`when`(model.getBulviuKose()).thenReturn(bulviuKose)

        // act
        presenter.onViewReady()

        // assert
        //verify(view).petrasyouliedtousaboutbulviukose()
        //verify(view, never()).thankPetras()
    }
}