package com.example.data.mapper.dto

import com.example.data.model.dto.FilmRequestDto
import com.example.domain.model.FilmRequest

fun FilmRequestDto.toModel(): FilmRequest =
        FilmRequest(results = results.map { it.toModel() })
