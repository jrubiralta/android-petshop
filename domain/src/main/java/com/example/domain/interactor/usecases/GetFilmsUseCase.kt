package com.example.domain.interactor.usecases

import com.example.domain.executor.Executor
import com.example.domain.interactor.SingleInteractor
import com.example.domain.model.Film
import com.example.domain.repository.FilmRepository
import io.reactivex.Single

class GetFilmsUseCase(val filmsRepository: FilmRepository,
                      executor: Executor)
    : SingleInteractor<List<Film>>(executor = executor) {

    private var genreId: String = ""

    fun execute(genreId: String,
                         onSuccess: (List<Film>) -> Unit,
                         onError: (Throwable) -> Unit) {

        this.genreId = genreId
        super.execute(onSuccess, onError)

    }
    override fun buildSingle(): Single<List<Film>> = filmsRepository.getGenreFilms(genreId)

}