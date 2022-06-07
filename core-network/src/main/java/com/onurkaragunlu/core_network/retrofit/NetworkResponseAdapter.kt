package com.onurkaragunlu.core_network.retrofit

import com.squareup.moshi.Moshi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type
import com.onurkaragunlu.core_network_model.Error
import com.onurkaragunlu.core_network_model.NetworkResponse

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
class NetworkResponseAdapter<T : Any>(
    private val successType: Type,
    private val errorBodyConverter: Converter<ResponseBody, Error>,
    private val moshi: Moshi
) : CallAdapter<T, Call<NetworkResponse<T>>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<T>): Call<NetworkResponse<T>> =
        NetworkResponseCall(call, errorBodyConverter, moshi)
}