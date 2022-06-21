package com.onurkaragunlu.feature_movie_impl.mapper

import com.onurkaragunlu.base_ui.mapper.UIMapper
import com.onurkaragunlu.domain_movie.model.Movie
import com.onurkaragunlu.feature_movie_impl.model.MovieUI
import javax.inject.Inject

/**
 * Created by Onur Karagünlü on 9.06.2022.
 */
class MovieUIMapper @Inject constructor() : UIMapper<Movie, MovieUI> {

    override fun mapToUIModel(domainModel: Movie): MovieUI = MovieUI(
        id = domainModel.id,
        name = domainModel.name,
        poster_path = domainModel.poster_path
    )
}