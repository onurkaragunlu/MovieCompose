package com.onurkaragunlu.core_model.network

import javax.inject.Qualifier

/**
 * Created by Onur Karagünlü on 6.06.2022.
 */

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher