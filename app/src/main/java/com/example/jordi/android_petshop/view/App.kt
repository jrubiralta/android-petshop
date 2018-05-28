package com.example.jordi.android_petshop.view

import android.app.Application
import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy
import com.example.jordi.android_petshop.di.appModule
import com.example.jordi.android_petshop.di.dataModule
import com.example.jordi.android_petshop.di.domainModule
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

/**
 * App.
 */
class App : Application(), KodeinAware {


    override val kodein by Kodein.lazy {
        import(appModule(this@App))
        import(domainModule)
        import(dataModule)
    }

    fun getRefWatcher(context: Context): RefWatcher {
        val application: App = context.applicationContext as App
        return application.refWatcher
    }

    lateinit var refWatcher: RefWatcher

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}