package com.example.jordi.android_petshop.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.model.FilmView
import com.example.jordi.android_petshop.presenter.films.FilmsListPresenter
import com.example.jordi.android_petshop.view.adapter.FilmAdapter
import kotlinx.android.synthetic.main.list_films.*

class FilmsActivity : RootActivity<FilmsListPresenter.View>(), FilmsListPresenter.View {

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<FilmsListPresenter>() with provider {
            FilmsListPresenter(
                    getFilmsUseCase = instance(),
                    errorHandler = instance(),
                    view = this@FilmsActivity)
        }
    }

    override val presenter: FilmsListPresenter by instance()

    private val filmListAdapter = FilmAdapter()

    override val layoutResourceId: Int = R.layout.list_films

    override fun showProgress() {
        //throw RuntimeException(getString(R.string.progress_no_available))
    }

    override fun hideProgress() {
        //throw RuntimeException(getString(R.string.progress_no_available))
    }

    override fun initializeUI() {
        films.adapter = filmListAdapter
        films.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun registerListeners() {

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showFilmList(filmsList: List<FilmView>) {
        filmListAdapter.addAll(filmsList)
        films.adapter = filmListAdapter
    }

    override fun getGenreId(): Int {
        val i: Bundle = getIntent().extras
        val genereId: Int = i.getInt("genreId")
        return genereId
    }
}

