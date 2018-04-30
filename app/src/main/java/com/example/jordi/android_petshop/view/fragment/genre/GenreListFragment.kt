package com.example.jordi.android_petshop.view.fragment.genre

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.model.GenreListView
import com.example.jordi.android_petshop.view.fragment.RootFragment
import com.example.jordi.android_petshop.presenter.genre.GenreListPresenter
import com.example.jordi.android_petshop.view.adapter.GenreAdapter
import kotlinx.android.synthetic.main.fragment_list_genre.*


class GenreListFragment : RootFragment<GenreListPresenter.View>(), GenreListPresenter.View {

    override val fragmentModule: Kodein.Module = Kodein.Module {
        bind<GenreListPresenter>() with provider {
            GenreListPresenter(
                    errorHandler = instance(),
                    view = this@GenreListFragment)
        }
    }

    override val presenter: GenreListPresenter by instance()

    override val layoutResourceId: Int = R.layout.fragment_list_genre

    private val adapter = GenreAdapter()

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initializeUI() {
        genreList.adapter = adapter
        genreList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
    }

    override fun getGenreList(): GenreListView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showGenreList(results: GenreListView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
