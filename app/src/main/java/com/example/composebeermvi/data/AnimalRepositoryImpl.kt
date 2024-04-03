package com.example.composebeermvi.data

import com.example.composebeermvi.data.mapper.AnimalMapper
import com.example.composebeermvi.domain.AnimalRepository
import com.example.composebeermvi.domain.model.Animal
import javax.inject.Inject

class AnimalRepositoryImpl @Inject constructor(
    private val animalApi: AnimalApi,
    private val mapper: AnimalMapper
) : AnimalRepository {
    override suspend fun getAnimals(): List<Animal> = animalApi.getAnimals().map { animalDto ->
        mapper.mapAnimal(animalDto)
    }
}