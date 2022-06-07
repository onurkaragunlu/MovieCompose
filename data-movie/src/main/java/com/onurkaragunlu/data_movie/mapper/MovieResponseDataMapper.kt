package com.onurkaragunlu.data_movie.mapper

import com.onurkaragunlu.base_data.extension.mapper.DataMapper
import com.onurkaragunlu.data_movie.model.MovieResponseDTO
import com.onurkaragunlu.domain_movie.model.MovieResponse
import javax.inject.Inject

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
class MovieResponseDataMapper @Inject constructor(
    private val movieDataMapper: MovieDataMapper
) : DataMapper<MovieResponseDTO,MovieResponse> {

    override fun mapToDomainModel(responseModel: MovieResponseDTO): MovieResponse = MovieResponse(
        page = responseModel.page,
        movieList = responseModel.movieList.orEmpty()
            .map { movieDTO -> movieDataMapper.mapToDomainModel(movieDTO) },
        total_pages = responseModel.total_pages,
        total_results = responseModel.total_results
    )
}