package com.example.jordi.android_petshop.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.data.constants.Constants
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.model.FilmView
import com.example.jordi.android_petshop.presenter.films.FilmsListPresenter
import com.example.jordi.android_petshop.view.adapter.FilmAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_films.*
import kotlinx.android.synthetic.main.view_progress.*
import java.net.URL

class FilmsActivity : RootActivity<FilmsListPresenter.View>(), FilmsListPresenter.View {

    companion object {
        const val TITLE = "title"
        const val DATA = "release_data"
        const val OVERVIEW = "overview"
        const val VOTE_AVERAGE = "vote_average"
        const val IMAGE_URL = "url"
    }

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<FilmsListPresenter>() with provider {
            FilmsListPresenter(
                    getFilmsUseCase = instance(),
                    errorHandler = instance(),
                    view = this@FilmsActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(filmsToolbar)
        supportActionBar?.title = getGenreName()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId

        if (id == android.R.id.home) {
            this.finish()
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showFilmList(filmsList: List<FilmView>) {
        filmListAdapter.addAll(filmsList)
    }

    override fun getGenreId(): Int {
        val i: Bundle = intent.extras
        val genereId: Int = i.getInt(Constants.GENRE)
        return genereId
    }

    override fun getGenreName(): String {
        val i: Bundle = intent.extras
        val genereName: String = i.getString(Constants.GENRE_NAME)
        return genereName
    }

    override fun navigateToFilmInfo(filmView: FilmView) {
        val intent = Intent(this, FilmInfoActivity::class.java)
        intent.putExtra(OVERVIEW, filmView.overview)
        intent.putExtra(DATA, filmView.release_date)
        intent.putExtra(VOTE_AVERAGE, filmView.vote_average)
        intent.putExtra(IMAGE_URL, filmView.getImage())
        intent.putExtra(TITLE, filmView.title)
        startActivity(intent)
    }
}

