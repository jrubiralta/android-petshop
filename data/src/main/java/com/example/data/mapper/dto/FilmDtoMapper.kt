package com.example.data.mapper.dto

import com.example.data.model.dto.FilmDto
import com.example.domain.model.Film


fun FilmDto.toModel(): Film =
        Film(poster_path = poster_path,
                id = id,
                title = title
)

