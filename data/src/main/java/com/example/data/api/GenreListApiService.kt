package com.example.data.api

import com.example.data.model.dto.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreListApiService {

    companion object {
        val ENDPOINT = "https://api.themoviedb.org/3/"
    }

    @GET ("genre/movie/list")
    fun getGenreList(@Query("api_key") key: String, @Query("language") language: String): Single<GenreResponseDto>

}

