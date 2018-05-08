package com.example.jordi.android_petshop.mapper

import com.example.domain.model.Film
import com.example.jordi.android_petshop.model.FilmView

fun Film.toView(): FilmView =
        FilmView(adult = adult,
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