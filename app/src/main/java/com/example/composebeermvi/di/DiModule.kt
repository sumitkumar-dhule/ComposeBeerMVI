package com.example.composebeermvi.di

import com.example.composebeermvi.data.AnimalApi
import com.example.composebeermvi.data.AnimalRepositoryImpl
import com.example.composebeermvi.data.mapper.AnimalMapper
import com.example.composebeermvi.domain.AnimalRepository
import com.example.composebeermvi.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Provides
    @Singleton
    internal fun provideBeerApi(): AnimalApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AnimalApi::class.java)

    @Provides
    fun provideRepo(animalApi: AnimalApi, mapper: AnimalMapper): AnimalRepository =
        AnimalRepositoryImpl(animalApi, mapper)

}