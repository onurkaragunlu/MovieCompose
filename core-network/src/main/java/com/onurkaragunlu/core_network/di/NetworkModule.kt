package com.onurkaragunlu.core_network.di

import com.onurkaragunlu.core_network.BuildConfig
import com.onurkaragunlu.core_network.retrofit.ApiKeyInterceptor
import com.onurkaragunlu.core_network.retrofit.NetworkResponseAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(ApiKeyInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshiConverter(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.API_URL)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            // .addConverterFactory( GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory(moshi))
            .build()
    }
}