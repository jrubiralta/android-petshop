package com.example.data.datasource.network

import com.example.domain.model.Film
import com.example.domain.model.GenreList
import io.reactivex.Single

interface NetworkDataSource {
    fun getGenreList(api_key: String, language: String): Single<GenreList>

    fun getGenreFilms(genre_id: String, api_key: String, language: String, include_adult: String, sort_by: String): Single<List<Film>>
}

