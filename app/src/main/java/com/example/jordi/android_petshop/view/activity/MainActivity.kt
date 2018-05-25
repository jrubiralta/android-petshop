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
import com.example.jordi.android_petshop.model.GenreListView
import com.example.jordi.android_petshop.presenter.genre.GenreListPresenter
import com.example.jordi.android_petshop.view.adapter.GenreAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_progress.*


class MainActivity : RootActivity<GenreListPresenter.View>(), GenreListPresenter.View {

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<GenreListPresenter>() with provider {
            GenreListPresenter(
                    getGenreUseCase = instance(),
                    errorHandler = instance(),
                    view = this@MainActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Géneros")
    }

    override val presenter: GenreListPresenter by instance()

    private val genreListAdapter = GenreAdapter(
            onItemClick = { presenter.onGenreClicked(it) }
    )

    override val layoutResourceId: Int = R.layout.activity_main

    override fun showProgress() {
        progress.show()
    }

    override fun hideProgress() {
        progress.hide()
    }

    override fun initializeUI() {
        genres.adapter = genreListAdapter
        genres.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun registerListeners() {
        // nothing to do
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showGenreList(genreList: GenreListView) {
        genreListAdapter.addAll(genreList.genresList)
    }

    override fun navigateToFilmsList(genreId: Int, genreName: String) {
        val intent = Intent(this, FilmsActivity::class.java)
        intent.putExtra(Constants.GENRE, genreId)
        intent.putExtra(Constants.GENRE_NAME, genreName)
        startActivity(intent)
    }
}

