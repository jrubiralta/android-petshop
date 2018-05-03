package com.example.jordi.android_petshop.view.activity

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.presenter.MainPresenter


class MainActivity : RootActivity<MainPresenter.View>(), MainPresenter.View {

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<MainPresenter>() with provider {
            MainPresenter(errorHandler = instance(), view = this@MainActivity)
        }
    }

    override val presenter: MainPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_main

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

}