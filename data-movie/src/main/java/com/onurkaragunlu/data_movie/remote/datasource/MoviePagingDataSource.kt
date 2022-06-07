package com.onurkaragunlu.data_movie.remote.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.onurkaragunlu.base_data.extension.getResourceFromResponse
import com.onurkaragunlu.core_model.network.MovieError
import com.onurkaragunlu.core_model.network.Resource
import com.onurkaragunlu.data_movie.mapper.MovieResponseDataMapper
import com.onurkaragunlu.data_movie.remote.api.MovieApi
import com.onurkaragunlu.domain_movie.model.Movie
import javax.inject.Inject

/**
 * Created by Onur Karagünlü on 7.06.2022.
 */
class MoviePagingDataSource @Inject constructor(
    private val movieApi: MovieApi,
    private val movieResponseDataMapper: MovieResponseDataMapper
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val nextPage = params.key ?: 1

        return when (val response = movieApi.getMovieList(nextPage).getResourceFromResponse()) {
            is Resource.Success -> {
                LoadResult.Page(
                    data = movieResponseDataMapper.mapToDomainModel(response.value).movieList,
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = if (response.value.total_pages > response.value.page) response.value.page + 1 else null
                )
            }
            is Resource.Failure -> {
                LoadResult.Error(response.error)
            }
            else -> {
                LoadResult.Error(MovieError.UnKnownError)
            }
        }
    }
}