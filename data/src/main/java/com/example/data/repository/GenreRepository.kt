package com.example.data.repository

import com.example.domain.model.Genre
import com.example.domain.repository.GenreRepository
import io.reactivex.Single

class GenreRepository() : GenreRepository {
    override fun getGenreList(api_key: String, language: String): Single<Genre> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}