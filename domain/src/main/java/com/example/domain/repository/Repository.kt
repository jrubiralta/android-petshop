package com.example.domain.repository

import com.example.domain.model.Genre
import io.reactivex.*

interface GenreRepository {
    fun getGenreList(api_key: String, language: String): Single<Genre>
}