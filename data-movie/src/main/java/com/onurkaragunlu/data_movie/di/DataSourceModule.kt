package com.onurkaragunlu.data_movie.di

import com.onurkaragunlu.data_movie.remote.datasource.MovieRemoteDataSource
import com.onurkaragunlu.data_movie.remote.datasource.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Onur Karagünlü on 5.06.2022.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(remoteDataSource: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}