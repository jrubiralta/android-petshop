package com.example.jordi.android_petshop.presenter

import com.example.jordi.android_petshop.exception.ErrorHandler
import io.reactivex.disposables.Disposable

/**
 * MainPresenter
 */
class MainPresenter(errorHandler: ErrorHandler,
                    view: MainPresenter.View)
    : Presenter<MainPresenter.View>(errorHandler, view) {

    override fun initialize() {

    }

    override fun resume() {

    }

    override fun stop() {

    }

    override fun destroy() {
        // Nothing to do yet
    }


    interface View : Presenter.View {

    }

}