package com.onurkaragunlu.core_model.network

import java.io.IOException

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
sealed class MovieError : IOException() {
    class ApiError(var code: Int, override var message: String) : MovieError()
    object UnKnownError : MovieError()
    class TimeOutException(override var message: String?) : MovieError()
    object NoConnectivityError : MovieError()
}