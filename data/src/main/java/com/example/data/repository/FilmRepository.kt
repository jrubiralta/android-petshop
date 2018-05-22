package com.example.data.repository

import com.example.data.datasource.network.NetworkDataSource
import com.example.domain.model.FilmRequest
import com.example.domain.repository.FilmRepository
import io.reactivex.Single

class FilmRepository(private val network: NetworkDataSource)
    : FilmRepository {
    override fun getGenreFilms(genre_id: Int): Single<FilmRequest> {
        return network.getGenreFilms(genre_id)
    }
}

