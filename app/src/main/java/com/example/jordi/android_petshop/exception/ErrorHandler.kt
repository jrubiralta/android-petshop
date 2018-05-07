package com.example.jordi.android_petshop.exception

import android.content.Context

/**
 * ErrorHandler.
 */
interface ErrorHandler {
    fun convert(e: Exception): String
}


class ErrorHandlerImpl(private val context: Context) : ErrorHandler {
    override fun convert(e: java.lang.Exception): String = "Error"
}