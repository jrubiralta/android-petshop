package com.example.jordi.android_petshop.executor

import com.example.domain.executor.Executor
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Executor.
 */

class RxExecutor : Executor {
    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun new(): Scheduler = Schedulers.io()
}