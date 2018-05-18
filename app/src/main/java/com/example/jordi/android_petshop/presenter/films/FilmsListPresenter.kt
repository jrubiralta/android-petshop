package com.example.jordi.android_petshop.presenter.films

import com.example.domain.interactor.usecases.GetFilmsUseCase
import com.example.domain.model.Film
import com.example.jordi.android_petshop.exception.ErrorHandler
import com.example.jordi.android_petshop.mapper.toView
import com.example.jordi.android_petshop.model.FilmView
import com.example.jordi.android_petshop.presenter.Presenter

class FilmsListPresenter(private val getFilmsUseCase: GetFilmsUseCase,
                         errorHandler: ErrorHandler,
                         view: FilmsListPresenter.View)
    : Presenter<FilmsListPresenter.View>(errorHandler, view) {



    override fun initialize() {
        val genereId: Int = view.getGenreId()
        getFilmsUseCase.execute(genreId = genereId, onSuccess = { filmsList ->  showFilmList(filmsList) },
                onError = { showError(it as  Exception) })
    }

    override fun resume() {

    }

    override fun stop() {
        getFilmsUseCase.clear()
    }

    override fun destroy() {

    }

    private fun showFilmList(filmsList: List<Film>) {
        val filmsListView = filmsList.map { it.toView() }
        view.showFilmList(filmsListView)
    }

    private fun showError(exception: Exception) {
        if (exception !is NoSuchElementException) {
            view.showError(errorHandler.convert(exception))
        }
    }

    interface View: Presenter.View {
        fun showFilmList(filmsList: List<FilmView>)
        fun getGenreId(): Int
    }

}