package com.onurkaragunlu.base_data.extension

import com.onurkaragunlu.core_model.network.MovieError
import com.onurkaragunlu.core_network_model.Error

/**
 * Created by Onur Karagünlü on 6.06.2022.
 */

fun Error.toMovieError(): MovieError {
    return when (this) {
        is Error.ApiError -> MovieError.ApiError(code, message)
        Error.NoConnectivityError -> MovieError.NoConnectivityError
        is Error.TimeOutException -> MovieError.TimeOutException(message)
        Error.UnKnownError -> MovieError.UnKnownError
    }
}

