package com.example.jordi.android_petshop.presenter.genre

import com.example.jordi.android_petshop.exception.ErrorHandler
import com.example.jordi.android_petshop.model.GenreListView
import com.example.jordi.android_petshop.presenter.Presenter


class GenreListPresenter(errorHandler: ErrorHandler,
                         view: GenreListPresenter.View)
    : Presenter<GenreListPresenter.View>(errorHandler, view) {

    override fun initialize() {
        val results = view.getGenreList()
        view.showGenreList(results)

    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    interface View: Presenter.View {
        fun getGenreList(): GenreListView
        fun showGenreList(results: GenreListView)
    }
}