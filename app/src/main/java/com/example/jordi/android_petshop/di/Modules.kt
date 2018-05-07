package com.example.jordi.android_petshop.di

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.example.data.api.*

import com.example.data.datasource.network.GenreNetwork
import com.example.data.datasource.network.NetworkDataSource
import com.example.data.repository.*
import com.example.domain.executor.Executor
import com.example.domain.interactor.usecases.GetGenreUseCase
import com.example.domain.model.GenreList
import com.example.domain.repository.*
import com.example.domain.repository.GenreRepository
import com.example.jordi.android_petshop.exception.ErrorHandler
import com.example.jordi.android_petshop.exception.ErrorHandlerImpl
import com.example.jordi.android_petshop.executor.RxExecutor


/**
 * Modules.
 */

fun appModule(context: Context) = Kodein.Module {
    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { RxExecutor() }
    bind<ErrorHandler>() with singleton { ErrorHandlerImpl(context = instance()) }
}

val domainModule = Kodein.Module {
    bind() from singleton { GetGenreUseCase(genreRepository = instance(), executor = instance()) }
}

val dataModule = Kodein.Module {


    /* API SERVICES */
    bind<GenreListApiService>() with singleton {
        createService(GenreListApiService::class.java, GenreListApiService.ENDPOINT)
    }

    /* DATA SOURCES */
    bind<NetworkDataSource>() with singleton {
        GenreNetwork(apiService = instance())
    }

    /* REPOSITORY */
    bind<GenreRepository>() with singleton { com.example.data.repository.GenreRepository(network = instance()) }
}