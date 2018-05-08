package com.example.data.api

import com.example.data.constants.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * ServiceCreator.
 */
fun <S> createService(clazz: Class<S>, endPoint: String): S {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(Constants.SERVER_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(Constants.SERVER_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(Constants.SERVER_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()


    val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(endPoint)
            .build()

    return retrofit.create(clazz)
}