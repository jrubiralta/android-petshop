package com.example.data.datasource.network

import com.example.data.api.GenreListApiService
import com.example.data.mapper.dto.toModel
import com.example.domain.model.FilmRequest
import com.example.domain.model.GenreList
import io.reactivex.Single

class NetworkDataSource (val apiService: GenreListApiService) {

    fun getGenreList(api_key: String, language: String): Single<GenreList> = apiService.getGenreList(api_key, language)
            .map { it.toModel() }

    fun getGenreFilms(genre_id: Int, api_key: String, language: String, include_adult: String, sort_by: String): Single<FilmRequest> =
            apiService.getGenreFilms(genre_id, api_key, language, include_adult, sort_by)
                    .map {
                        it.toModel()
                    }
}
