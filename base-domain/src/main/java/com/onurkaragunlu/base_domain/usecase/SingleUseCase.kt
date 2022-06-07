package com.onurkaragunlu.base_domain.usecase

import com.onurkaragunlu.core_model.network.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Created by Onur Karagünlü on 7.06.2022.
 */
abstract class SingleUseCase<in Params, Type> constructor(
    private val dispatcher: CoroutineDispatcher
) {
    abstract suspend fun getExecutable(params: Params): Resource<Type>

    suspend operator fun invoke(params: Params): Resource<Type> {
        return withContext(dispatcher) {
            getExecutable(params)
        }
    }
}