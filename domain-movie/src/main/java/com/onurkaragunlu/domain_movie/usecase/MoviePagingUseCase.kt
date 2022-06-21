package com.onurkaragunlu.domain_movie.usecase

import androidx.paging.PagingData
import com.onurkaragunlu.base_domain.usecase.FlowUseCase
import com.onurkaragunlu.core_model.network.IoDispatcher
import com.onurkaragunlu.domain_movie.model.Movie
import com.onurkaragunlu.domain_movie.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Onur Karagünlü on 7.06.2022.
 */
class MoviePagingUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, PagingData<Movie>>(dispatcher) {

    override  fun getExecutable(params: Unit): Flow<PagingData<Movie>> {
        return movieRepository.getMovieListFlow()
    }
}