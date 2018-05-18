package com.example.jordi.android_petshop.mapper

import com.example.domain.model.FilmRequest
import com.example.jordi.android_petshop.model.FilmRequestView

fun FilmRequest.toView(): FilmRequestView =
        FilmRequestView(results = results.map { it.toView()})