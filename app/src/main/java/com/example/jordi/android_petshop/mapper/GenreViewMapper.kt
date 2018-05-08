package com.example.jordi.android_petshop.mapper

import com.example.domain.model.Genre
import com.example.jordi.android_petshop.model.GenreView

fun Genre.toView(): GenreView =
        GenreView(id = id,
                name = name)