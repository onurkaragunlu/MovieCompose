package com.onurkaragunlu.core_network_model

import java.io.IOException


/**
 * Created by Onur Karagünlü on 6.06.2022.
 */

sealed class Error : IOException() {
    //@JsonClass(generateAdapter = true)
    class ApiError(val code: Int, override val message: String) : Error()

    //@JsonClass(generateAdapter = true)
    object UnKnownError : Error()

    //@JsonClass(generateAdapter = true)
    class TimeOutException(override val message: String?) : Error()

    //@JsonClass(generateAdapter = true)
    object NoConnectivityError : Error()
}