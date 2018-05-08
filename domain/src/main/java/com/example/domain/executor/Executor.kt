package com.example.domain.executor

import io.reactivex.Scheduler

/**
 * Executor.
 */

interface Executor {
    fun main(): Scheduler

    fun new(): Scheduler
}
