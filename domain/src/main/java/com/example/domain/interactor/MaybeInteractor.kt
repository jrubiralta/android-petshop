package com.example.domain.interactor

import com.example.domain.executor.Executor
import io.reactivex.Maybe
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableMaybeObserver

/**
 * MaybeInteractor
 */
abstract class MaybeInteractor<T : Any>(private val executor: Executor,
                                        private val compositeDisposable: CompositeDisposable = CompositeDisposable()) {

    fun execute(onSuccess: (T) -> Unit,
                onEmpty: () -> Unit,
                onError: (Throwable) -> Unit): Maybe<T> {
        val maybe = buildMaybe()
                .subscribeOn(executor.new())
                .observeOn(executor.main())

        compositeDisposable.add(maybe
                .subscribeWith(object : DisposableMaybeObserver<T>() {
                    var success = false
                    override fun onError(e: Throwable) {
                        onError(e)
                    }

                    override fun onSuccess(t: T) {
                        success = true
                        onSuccess(t)
                    }

                    override fun onComplete() {
                        if (!success) onEmpty()
                    }
                }))

        return maybe
    }

    fun clear() {
        compositeDisposable.clear()
    }

    abstract fun buildMaybe(): Maybe<T>
}