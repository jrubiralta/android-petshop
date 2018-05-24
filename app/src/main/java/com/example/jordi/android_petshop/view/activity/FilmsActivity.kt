package com.example.jordi.android_petshop.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.data.constants.Constants
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.model.FilmView
import com.example.jordi.android_petshop.presenter.films.FilmsListPresenter
import com.example.jordi.android_petshop.view.adapter.FilmAdapter
import kotlinx.android.synthetic.main.list_films.*
import kotlinx.android.synthetic.main.view_progress.*

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

    private val filmListAdapter = FilmAdapter(
            onItemClick = { presenter.onFilmClicked(it)}
    )

    override val layoutResourceId: Int = R.layout.list_films

    override fun showProgress() {
        progress.show()
    }

    override fun hideProgress() {
        progress.hide()
    }

    override fun initializeUI() {
        films.adapter = filmListAdapter
        films.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun registerListeners() {
        // nothing to do
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showFilmList(filmsList: List<FilmView>) {
        filmListAdapter.addAll(filmsList)
    }

    override fun getGenreId(): Int {
        val i: Bundle = intent.extras
        val genereId: Int = i.getInt(Constants.GENRE)
        return genereId
    }

    override fun navigateToFilmInfo(filmView: FilmView) {
        val intent = Intent(this, FilmInfoActivity::class.java)
        intent.putExtra("overview", filmView.overview)
        intent.putExtra("release_data", filmView.release_date)
        intent.putExtra("vote_average", filmView.vote_average)
        intent.putExtra("image_url", filmView.getImage())
        intent.putExtra("title", filmView.title)
        startActivity(intent)
    }
}

