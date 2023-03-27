package org.a_cyb.hitchhikersmap.api.di

import org.a_cyb.hitchhikersmap.api.ApiHelper
import org.a_cyb.hitchhikersmap.api.ApiHelperImpl
import org.a_cyb.hitchhikersmap.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideBaseUrl() = "https://ssd.jpl.nasa.gov/"

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper
}