package com.example.jordi.android_petshop.model

data class FilmView(val poster_path: String,
                    val id: Int,
                    val title: String) {

    companion object {
        val URL = "https://image.tmdb.org/t/p/w500"
    }

    fun getImage(): String {
        return URL + poster_path
    }
}

