package com.example.jordi.android_petshop.mapper

import com.example.domain.model.FilmRequest
import com.example.jordi.android_petshop.model.FilmRequestView

fun FilmRequest.toView(): FilmRequestView =
        FilmRequestView(id = id,
                page = page,
                results = results.map { it.toView()},
                total_pages = total_pages,
                total_results = total_results)