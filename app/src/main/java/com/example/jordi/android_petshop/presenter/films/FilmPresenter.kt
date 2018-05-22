package com.example.jordi.android_petshop.presenter.films

import com.example.jordi.android_petshop.exception.ErrorHandler
import com.example.jordi.android_petshop.presenter.Presenter


class FilmPresenter(errorHandler: ErrorHandler,
                    view: FilmPresenter.View)
    : Presenter<FilmPresenter.View>(errorHandler, view) {



    override fun initialize() {
        view.getFilmDetails()
    }

    override fun resume() {
        // nothing to do
    }

    override fun stop() {
        // nothing to do
    }

    override fun destroy() {
        // nothing to do
    }

    private fun showError(exception: Exception) {
        onError { exception }
    }

    interface View: Presenter.View {
        fun getFilmDetails()
    }

}