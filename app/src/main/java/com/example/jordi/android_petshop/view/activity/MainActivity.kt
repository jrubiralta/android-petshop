package com.example.jordi.android_petshop.view.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.model.GenreListView
import com.example.jordi.android_petshop.presenter.genre.GenreListPresenter
import com.example.jordi.android_petshop.view.adapter.GenreAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : RootActivity<GenreListPresenter.View>(), GenreListPresenter.View {

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<GenreListPresenter>() with provider {
            GenreListPresenter(
                    getGenreUseCase = instance(),
                    errorHandler = instance(),
                    view = this@MainActivity)
        }
    }

    override val presenter: GenreListPresenter by instance()

    private val genreListAdapter = GenreAdapter(
            onItemClick = { presenter.onGenreClicked(it) }
    )

    override val layoutResourceId: Int = R.layout.activity_main

    override fun showProgress() {
        //throw RuntimeException(getString(R.string.progress_no_available))
    }

    override fun hideProgress() {
        //throw RuntimeException(getString(R.string.progress_no_available))
    }

    override fun initializeUI() {
        genres.adapter = genreListAdapter
        genres.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun registerListeners() {
        //genres.setOnClickListener {  }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showGenreList(genreList: GenreListView) {
        genreListAdapter.addAll(genreList.genresList)
        genres.adapter = genreListAdapter
    }

    override fun navigateToFilmsList(genreId: Int) {
        val intent = Intent(this, FilmsActivity::class.java)
        intent.putExtra("genreId", genreId)
        startActivity(intent)
    }
}

