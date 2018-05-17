package com.example.domain.model

data class FilmRequest(val id: Int,
                          val page: Int,
                          val results: List<Film>,
                          val total_pages: Int,
                          val total_results: Int)