package com.example.data.mapper.dto

import com.example.data.model.dto.GenreDto
import com.example.data.model.dto.GenreResponseDto
import com.example.domain.model.GenreList
import com.example.domain.model.Genre


fun GenreResponseDto.toModel(): GenreList =
        GenreList(genresList = genres.map { it.toModel()  })

fun GenreList.toData(): GenreResponseDto =
        GenreResponseDto(genres = genresList.map { it.toData() })

