package com.example.jordi.android_petshop.view

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy
import com.example.jordi.android_petshop.di.appModule
import com.example.jordi.android_petshop.di.dataModule
import com.example.jordi.android_petshop.di.domainModule

/**
 * App.
 */
class App : Application(), KodeinAware {


    override val kodein by Kodein.lazy {
        import(appModule(this@App))
        import(domainModule)
        import(dataModule)
    }

    override fun onCreate() {
        super.onCreate()
    }
}