package com.example.data.mapper.dto

import com.example.data.model.dto.FilmDto
import com.example.domain.model.Film


fun FilmDto.toModel(): Film =
        Film(adult = adult,
                backdrop_path = backdrop_path,
                genre_ids = genre_ids,
                id = id,
                original_language = original_language,
                original_title = original_title,
                overview = overview,
                release_date = release_date,
                popularity = popularity,
                title = title,
                video = video,
                vote_average = vote_average,
                vote_count = vote_count)


fun Film.toData(): FilmDto =
        FilmDto(adult = adult,
                backdrop_path = backdrop_path,
                genre_ids = genre_ids,
                id = id,
                original_language = original_language,
                original_title = original_title,
                overview = overview,
                release_date = release_date,
                popularity = popularity,
                title = title,
                video = video,
                vote_average = vote_average,
                vote_count = vote_count)