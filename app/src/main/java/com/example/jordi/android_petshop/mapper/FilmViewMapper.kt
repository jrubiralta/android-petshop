package com.example.jordi.android_petshop.mapper

import com.example.domain.model.Film
import com.example.jordi.android_petshop.model.FilmView

fun Film.toView(): FilmView =
        FilmView(poster_path = poster_path,
                id = id,
                overview = overview,
                release_date = release_date,
                title = title,
                vote_average = vote_average
        )