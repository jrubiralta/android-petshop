package com.example.jordi.android_petshop.view.activity

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.extensions.load
import com.example.jordi.android_petshop.presenter.films.FilmPresenter
import kotlinx.android.synthetic.main.film_information.*


class FilmInfoActivity : RootActivity<FilmPresenter.View>(), FilmPresenter.View {

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<FilmPresenter>() with provider {
            FilmPresenter(
                    errorHandler = instance(),
                    view = this@FilmInfoActivity)
        }
    }

    override val presenter: FilmPresenter by instance()

    // private val filmAdapter

    override val layoutResourceId: Int = R.layout.film_information

    override fun showProgress() {
        //throw RuntimeException(getString(R.string.progress_no_available))
    }

    override fun hideProgress() {
        //throw RuntimeException(getString(R.string.progress_no_available))
    }

    override fun initializeUI() {

    }

    override fun registerListeners() {

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun getFilmInfo() {
        val i: Bundle = intent.extras
        titleFilm.text = i.getString("title")
        date.text = i.getString("release_data")
        overview.text = i.getString("overview")
        average.text = i.getDouble("vote_average").toString()
        image.load(i.getString("image_url"))
    }
}