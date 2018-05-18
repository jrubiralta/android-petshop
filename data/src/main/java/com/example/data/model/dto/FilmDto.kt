package com.example.data.model.dto

data class FilmDto(var poster_path: String,
                    var adult: Boolean,
                    var backdrop_path: String,
                    var genre_ids: List<Int>,
                    var id: Int,
                    var original_language: String,
                    var original_title: String,
                    var overview: String?,
                    var release_date: String,
                    var popularity: String,
                    var title: String,
                    var video: Boolean,
                    var vote_average: Double,
                    var vote_count: Int)