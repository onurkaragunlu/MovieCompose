package com.onurkaragunlu.feature_movie_impl.model

import com.onurkaragunlu.base_ui.mapper.UIModel

/**
 * Created by Onur Karagünlü on 9.06.2022.
 */
data class MovieUI(
    val id: Int,
    val name: String,
    val poster_path: String
) : UIModel {
}