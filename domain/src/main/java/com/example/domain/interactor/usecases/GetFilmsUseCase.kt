package com.example.domain.interactor.usecases

import com.example.domain.executor.Executor
import com.example.domain.interactor.SingleInteractor
import com.example.domain.model.Film
import com.example.domain.repository.FilmRepository
import io.reactivex.Single

class GetFilmsUseCase(val genreId: String,
                      val filmsRepository: FilmRepository,
                      executor: Executor)
    : SingleInteractor<List<Film>>(executor = executor) {

    override fun buildSingle(): Single<List<Film>> = filmsRepository.getGenreFilms(genreId)

}