package com.example.jordi.android_petshop.presenter.genre

import android.text.GetChars
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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