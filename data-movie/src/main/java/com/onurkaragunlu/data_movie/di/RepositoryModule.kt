package com.onurkaragunlu.data_movie.di

import com.onurkaragunlu.data_movie.repository.MovieRepositoryImpl
import com.onurkaragunlu.domain_movie.repository.MovieRepository
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
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(movieRepository: MovieRepositoryImpl): MovieRepository

}