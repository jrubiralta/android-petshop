package com.example.jordi.android_petshop.model

data class FilmRequestView(val id: Int,
                       val page: Int,
                       val results: List<FilmView>,
                       val total_pages: Int,
                       val total_results: Int)