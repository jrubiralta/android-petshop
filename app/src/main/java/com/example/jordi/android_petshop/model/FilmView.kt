package com.example.jordi.android_petshop.model

data class FilmView(val adult: Boolean,
                val backdrop_path: String,
                val genre_ids: List<Int>,
                val id: Int,
                val original_language: String,
                val original_title: String,
                val overview: String,
                val release_date: String,
                val popularity: String,
                val title: String,
                val video: Boolean,
                val vote_average: Int,
                val vote_count: Int)