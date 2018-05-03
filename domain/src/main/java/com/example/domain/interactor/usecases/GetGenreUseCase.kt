package com.example.domain.interactor.usecases

import com.example.domain.executor.Executor
import com.example.domain.interactor.SingleInteractor
import com.example.domain.model.Genre
import com.example.domain.model.GenreList
import com.example.domain.repository.GenreRepository
import io.reactivex.Single

class GetGenreUseCase(val genreRepository: GenreRepository,
                      executor: Executor)
    : SingleInteractor<GenreList>(executor = executor) {

    override fun buildSingle(): Single<GenreList> = genreRepository.getGenreList()

}