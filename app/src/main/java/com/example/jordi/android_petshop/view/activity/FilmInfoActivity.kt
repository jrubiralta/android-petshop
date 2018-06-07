package com.example.jordi.android_petshop.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NavUtils.navigateUpFromSameTask
import android.view.MenuItem
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.extensions.load
import com.example.jordi.android_petshop.presenter.films.FilmPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.film_information.*
import kotlinx.android.synthetic.main.view_progress.*


class FilmInfoActivity : RootActivity<FilmPresenter.View>(), FilmPresenter.View {

    companion object {
        const val TITLE = "title"
        const val DATA = "release_data"
        const val OVERVIEW = "overview"
        const val VOTE_AVERAGE = "vote_average"
        const val IMAGE_URL = "url"
    }

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<FilmPresenter>() with provider {
            FilmPresenter(
                    errorHandler = instance(),
                    view = this@FilmInfoActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(filmInfoToolbar)
        supportActionBar?.title = getFilmTitle()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override val presenter: FilmPresenter by instance()

    // private val filmAdapter

    override val layoutResourceId: Int = R.layout.film_information

    override fun showProgress() {
        progress.show()
    }

    override fun hideProgress() {
        progress.hide()
    }

    override fun initializeUI() {
        // nothing to do
    }

    override fun registerListeners() {
        // nothing to do
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId

        if (id == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun getFilmTitle(): String {
        val i: Bundle = intent.extras
        val filmTitle = i.getString(TITLE)
        return filmTitle
    }

    override fun getFilmDetails() {
        val i: Bundle = intent.extras
        titleFilm.text = i.getString(TITLE)
        date.text = i.getString(DATA)
        overview.text = i.getString(OVERVIEW)
        average.text = i.getDouble(VOTE_AVERAGE).toString()
        image.load(i.getString(IMAGE_URL))
    }
}