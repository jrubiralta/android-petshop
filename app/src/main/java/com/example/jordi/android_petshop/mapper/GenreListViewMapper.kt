package com.example.jordi.android_petshop.mapper

import com.example.domain.model.GenreList
import com.example.jordi.android_petshop.model.GenreListView

fun GenreList.toView(): GenreListView =
        GenreListView(genresList = genresList)

