package com.example.jordi.android_petshop.model

data class FilmView(val poster_path: String,
                    val id: Int,
                    val overview: String?,
                    val release_date: String,
                    val title: String,
                    val vote_average: Double) {

    companion object {
        val URL = "https://image.tmdb.org/t/p/w500"
    }

    fun getImage(): String {
        return URL + poster_path
    }
}

