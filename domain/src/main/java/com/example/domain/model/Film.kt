package com.example.domain.model

data class Film(val adult: Boolean,
                    val backdrop_path: String,
                    val genre_ids: List<Int>,
                    val id: Int,
                    val original_language: String,
                    val original_title: String,
                    val overview: String?,
                    val release_date: String,
                    val popularity: String,
                    val title: String,
                    val video: Boolean,
                    val vote_average: Double,
                    val vote_count: Int)