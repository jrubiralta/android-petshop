package com.example.data.mapper.dto

import com.example.data.model.dto.FilmDto
import com.example.data.model.dto.FilmRequestDto
import com.example.domain.model.FilmRequest

fun FilmRequestDto.toModel(): FilmRequest =
        FilmRequest(id = id,
                page = page,
                results = results.map { it.toModel() },
                total_pages = total_pages,
                total_results = total_results)

fun FilmRequest.toData(): FilmRequestDto =
        FilmRequestDto(id = id,
                page = page,
                results = results.map { it.toData() },
                total_pages = total_pages,
                total_results = total_results)
