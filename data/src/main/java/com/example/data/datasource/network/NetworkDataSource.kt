package com.example.data.datasource.network

import com.example.data.api.GenreListApiService
import com.example.data.constants.Constants
import com.example.data.mapper.dto.toModel
import com.example.domain.model.FilmRequest
import com.example.domain.model.GenreList
import io.reactivex.Single

class NetworkDataSource (val apiService: GenreListApiService) {

    fun getGenreList(): Single<GenreList> = apiService.getGenreList(Constants.API_KEY, "es-ES")
            .map { it.toModel() }

    fun getGenreFilms(genre_id: Int): Single<FilmRequest> =
            apiService.getGenreFilms(genre_id, Constants.API_KEY, "es-ES", "false", "created_at.asc")
                    .map {
                        it.toModel()
                    }
}
