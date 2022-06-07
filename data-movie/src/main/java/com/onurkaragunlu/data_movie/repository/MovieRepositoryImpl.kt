package com.onurkaragunlu.data_movie.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.onurkaragunlu.core_model.network.Resource
import com.onurkaragunlu.data_movie.mapper.MovieResponseDataMapper
import com.onurkaragunlu.data_movie.remote.datasource.MoviePagingDataSource
import com.onurkaragunlu.data_movie.remote.datasource.MovieRemoteDataSource
import com.onurkaragunlu.domain_movie.model.Movie
import com.onurkaragunlu.domain_movie.model.MovieResponse
import com.onurkaragunlu.domain_movie.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Onur Karagünlü on 5.06.2022.
 */
class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val moviePagingDataSource: MoviePagingDataSource,
    private val movieResponseDataMapper: MovieResponseDataMapper
) : MovieRepository {
    override suspend fun getMovieList(page: Int): Resource<MovieResponse> {
        return when (val response = remoteDataSource.getMovieList(page)) {
            is Resource.Success -> {
                Resource.Success(movieResponseDataMapper.mapToDomainModel(response.value))
            }
            is Resource.Failure -> {
                Resource.Failure(response.error)
            }
        }
    }

    override fun getMovieListFlow(): Flow<PagingData<Movie>> = Pager(PagingConfig(pageSize = 50)) {
        moviePagingDataSource
    }.flow
}