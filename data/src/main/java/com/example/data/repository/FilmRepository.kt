package com.example.data.repository

import com.example.data.datasource.network.NetworkDataSource
import com.example.domain.model.Film
import com.example.domain.repository.FilmRepository
import io.reactivex.Single

class FilmRepository(private val network: NetworkDataSource)
    : FilmRepository {
    override fun getGenreFilms(genre_id: Int, api_key: String, language: String, include_adult: String, sort_by: String): Single<List<Film>> {
        return network.getGenreFilms(genre_id, api_key, language, include_adult, sort_by)
    }
}

