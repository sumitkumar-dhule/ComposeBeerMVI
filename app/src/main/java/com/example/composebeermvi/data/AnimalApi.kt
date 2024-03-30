package com.example.composebeermvi.data

import com.example.composebeermvi.data.dto.AnimalDto
import retrofit2.http.GET

interface AnimalApi {
    @GET("animals.json")
    suspend fun getAnimals(): List<AnimalDto>

}