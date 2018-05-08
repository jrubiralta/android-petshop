package com.example.jordi.android_petshop.presenter.genre

import android.util.Log
import com.example.domain.interactor.usecases.GetGenreUseCase
import com.example.jordi.android_petshop.exception.ErrorHandler
import com.example.domain.model.GenreList
import com.example.jordi.android_petshop.mapper.toView
import com.example.jordi.android_petshop.model.GenreListView
import com.example.jordi.android_petshop.presenter.Presenter


class GenreListPresenter(private val getGenreUseCase: GetGenreUseCase,
                         errorHandler: ErrorHandler,
                         view: GenreListPresenter.View)
    : Presenter<GenreListPresenter.View>(errorHandler, view) {

    override fun initialize() {

        getGenreUseCase.execute(onSuccess = { genreList ->  showGenreList(genreList) },
                onError = { showError(it as  Exception) })
    }

    override fun resume() {

    }

    override fun stop() {
        getGenreUseCase.clear()
    }

    override fun destroy() {

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

    interface View: Presenter.View {
        fun showGenreList(genreListView: GenreListView)
    }
}