package com.example.jordi.android_petshop.presenter.genre

import com.example.domain.interactor.usecases.GetGenreUseCase
import com.example.jordi.android_petshop.exception.ErrorHandler
import com.example.domain.model.GenreList
import com.example.jordi.android_petshop.mapper.toView
import com.example.jordi.android_petshop.model.GenreListView
import com.example.jordi.android_petshop.model.GenreView
import com.example.jordi.android_petshop.presenter.Presenter


class GenreListPresenter(private val getGenreUseCase: GetGenreUseCase,
                         errorHandler: ErrorHandler,
                         view: GenreListPresenter.View)
    : Presenter<GenreListPresenter.View>(errorHandler, view) {

    override fun initialize() {

        getGenreUseCase.execute(
                onSuccess = { genreList ->  showGenreList(genreList) },
                onError = { showError(it as  Exception) })
    }

    override fun resume() {

    }

    override fun stop() {
    }

    override fun destroy() {
        getGenreUseCase.clear()
    }

    private fun showGenreList(genreList: GenreList) {
        val genreListView = genreList.toView()
        view.showGenreList(genreListView)
    }

    private fun showError(exception: Exception) {
        if (exception !is NoSuchElementException) {
            view.showError(errorHandler.convert(exception))
        }
    }

    fun onGenreClicked(genreView: GenreView) {
        view.navigateToFilmsList(genreView.id, genreView.name)
    }

    interface View: Presenter.View {
        fun showGenreList(genreListView: GenreListView)
        fun navigateToFilmsList(genreId: Int, genreName: String)
    }
}