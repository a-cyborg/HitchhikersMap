package org.a_cyb.hitchhikersmap.api.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.a_cyb.hitchhikersmap.api.HorizonsApiHelperImpl
import org.a_cyb.hitchhikersmap.api.HorizonsApiHelper
import org.a_cyb.hitchhikersmap.api.HorizonsApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideBaseUrl(): String = "https://ssd.jpl.nasa.gov/"

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): HorizonsApiService =
        retrofit.create(HorizonsApiService::class.java)

    @Singleton
    @Provides
    fun provideApiHelper(apiHelper: HorizonsApiHelperImpl): HorizonsApiHelper = apiHelper
}