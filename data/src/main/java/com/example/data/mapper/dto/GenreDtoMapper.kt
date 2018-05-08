package com.example.data.mapper.dto

import com.example.data.model.dto.GenreDto
import com.example.domain.model.Genre

fun GenreDto.toModel(): Genre =
        Genre(id = id,
              name = name)


fun Genre.toData(): GenreDto =
        GenreDto(id = id,
                name = name)
