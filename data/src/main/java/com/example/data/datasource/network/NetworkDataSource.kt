package com.example.data.datasource.network

import com.example.domain.model.GenreList
import io.reactivex.Single

interface NetworkDataSource {
    fun getGenreList(api_key: String, language: String): Single<GenreList>
}

