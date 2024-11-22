package com.bhavesh.vridapp.di

import com.bhavesh.vridapp.common.Constants.BASE_URL
import com.bhavesh.vridapp.data.remote.api.VridApi
import com.bhavesh.vridapp.data.repository.VridRepositoryImp
import com.bhavesh.vridapp.domain.repository.VridRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMarvelApi() : VridApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VridApi::class.java)
    }
    @Provides
    @Singleton
    fun provideMarvelRepository(api: VridApi): VridRepository {
        return VridRepositoryImp(api)
    }
}