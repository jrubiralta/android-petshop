package com.example.jordi.android_petshop.exception

/**
 * ErrorHandler.
 */
interface ErrorHandler {
    fun convert(e: Exception): String
}
