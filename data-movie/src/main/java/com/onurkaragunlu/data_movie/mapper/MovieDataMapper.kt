package com.onurkaragunlu.data_movie.mapper

import com.onurkaragunlu.base_data.extension.mapper.DataMapper
import com.onurkaragunlu.data_movie.model.MovieDTO
import com.onurkaragunlu.domain_movie.model.Movie
import javax.inject.Inject

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
class MovieDataMapper @Inject constructor() : DataMapper<MovieDTO, Movie> {

    override fun mapToDomainModel(responseModel: MovieDTO): Movie = Movie(
        backdrop_path = responseModel.backdrop_path.orEmpty(),
        first_air_date = responseModel.first_air_date.orEmpty(),
        genre_ids = responseModel.genre_ids.orEmpty(),
        //TODO change here
        id = responseModel.id ?: 0,
        name = responseModel.name.orEmpty(),
        origin_country = responseModel.origin_country.orEmpty(),
        original_language = responseModel.original_language.orEmpty(),
        original_title = responseModel.original_title.orEmpty(),
        overview = responseModel.overview.orEmpty(),
        popularity = responseModel.popularity,
        poster_path = responseModel.poster_path.orEmpty(),
        vote_average = responseModel.vote_average,
        vote_count = responseModel.vote_count
    )
}