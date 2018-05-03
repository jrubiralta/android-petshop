package com.example.data.datasource.network

import com.example.data.api.GenreListApiService
import com.example.data.mapper.dto.toModel
import com.example.domain.model.GenreList
import io.reactivex.Single

class GenreNetwork(val apiService: GenreListApiService) : NetworkDataSource {

    override fun getGenreList(api_key: String, language: String): Single<GenreList> = apiService.getGenreList(api_key, language)
            .map { it.toModel() }
}