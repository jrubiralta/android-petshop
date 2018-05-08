package com.example.domain.repository

import com.example.domain.model.Film
import com.example.domain.model.GenreList
import io.reactivex.*

interface GenreRepository {
    fun getGenreList(api_key: String = "78c6f27b8b8c5e87706116266c146b9b", language: String = "es-ES"): Single<GenreList>
}

interface FilmRepository {
    fun getGenreFilms(genre_id: String,
                      api_key: String = "78c6f27b8b8c5e87706116266c146b9b",
                      language: String = "es-ES",
                      include_adult: String = "false",
                      sort_by: String = "created_at.asc"): Single<List<Film>>
}