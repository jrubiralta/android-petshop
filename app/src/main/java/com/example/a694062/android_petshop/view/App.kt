package com.example.a694062.android_petshop.view

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy

import io.fabric.sdk.android.Fabric
import io.realm.Realm

/**
 * App.
 */
class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {

    }

    override fun onCreate() {
        super.onCreate()

        Fabric.with(this, Crashlytics())
        Realm.init(this)
    }
}