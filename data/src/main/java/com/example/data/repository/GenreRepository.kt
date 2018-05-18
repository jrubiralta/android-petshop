package com.example.data.repository

import com.example.data.datasource.network.NetworkDataSource
import com.example.domain.model.GenreList
import com.example.domain.repository.GenreRepository
import io.reactivex.Single

class GenreRepository(private val network: NetworkDataSource) : GenreRepository {
    override fun getGenreList(api_key: String, language: String): Single<GenreList> {
        return network.getGenreList(api_key, language)
    }
}