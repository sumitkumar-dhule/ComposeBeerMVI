package com.example.composebeermvi.domain

import com.example.composebeermvi.domain.model.Animal

interface AnimalRepository {
    suspend fun getAnimals():List<Animal>

}