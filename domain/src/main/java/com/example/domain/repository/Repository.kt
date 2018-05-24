package com.example.domain.repository

import com.example.domain.model.FilmRequest
import com.example.domain.model.GenreList
import io.reactivex.*

interface GenreRepository {
    fun getGenreList(): Single<GenreList>
}

interface FilmRepository {
    fun getGenreFilms(genre_id: Int): Single<FilmRequest>

}


//api_key: String = "78c6f27b8b8c5e87706116266c146b9b",
//language: String = "es-ES",
//include_adult: String = "false",
//sort_by: String = "created_at.asc"