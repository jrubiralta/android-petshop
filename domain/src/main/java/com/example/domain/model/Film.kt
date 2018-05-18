package com.example.domain.model

data class Film(val poster_path: String,
                val id: Int,
                val overview: String?,
                val release_date: String,
                val title: String,
                val vote_average: Double)