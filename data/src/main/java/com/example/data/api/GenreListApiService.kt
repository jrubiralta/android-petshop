package com.example.data.api

import com.example.data.model.dto.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GenreListApiService {

    companion object {
        val ENDPOINT = "https://api.themoviedb.org/3/"
    }

    @GET ("genre/movie/list")
    fun getGenreList(@Query("api_key") key: String, @Query("language") language: String): Single<GenreResponseDto>

    @GET("genre/{genre_id}/movies")
    fun getGenreFilms(@Path("genre_id") id: String, @Query("api_key") key: String, @Query("language") language: String,
                      @Query("include_adult") adult: String, @Query("sort_by") sort_by: String): Single<List<FilmDto>>

}

