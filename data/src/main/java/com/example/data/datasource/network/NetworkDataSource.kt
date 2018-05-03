package com.example.data.datasource.network

import com.example.domain.model.GenreList
import io.reactivex.Single

interface NetworkDataSource {
    fun getGenreList(api_key: String = "78c6f27b8b8c5e87706116266c146b9b", language: String = "es-ES"): Single<GenreList>
}

