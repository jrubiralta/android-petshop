package com.example.data.model.dto

data class FilmRequestDto(var id: Int,
                          var page: Int,
                          var results: List<FilmDto>,
                          var total_pages: Int,
                          var total_results: Int)