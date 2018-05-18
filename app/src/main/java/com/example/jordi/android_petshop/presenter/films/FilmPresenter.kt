package com.example.jordi.android_petshop.presenter.films

import com.example.jordi.android_petshop.exception.ErrorHandler
import com.example.jordi.android_petshop.presenter.Presenter


class FilmPresenter(errorHandler: ErrorHandler,
                    view: FilmPresenter.View)
    : Presenter<FilmPresenter.View>(errorHandler, view) {



    override fun initialize() {

    }

    override fun resume() {

    }

    override fun stop() {
    }

    override fun destroy() {

    }

    private fun showError(exception: Exception) {
        if (exception !is NoSuchElementException) {
            view.showError(errorHandler.convert(exception))
        }
    }

    interface View: Presenter.View {

    }

}