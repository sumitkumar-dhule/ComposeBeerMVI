package com.example.composebeermvi.data

import com.example.composebeermvi.domain.AnimalRepository
import com.example.composebeermvi.domain.model.Animal
import javax.inject.Inject

class AnimalRepositoryImpl @Inject constructor(private val animalApi: AnimalApi) : AnimalRepository {
    override suspend fun getAnimals(): List<Animal> = animalApi.getAnimals().map { animalDto ->
        Animal(
            image = animalDto.image,
            name = animalDto.name,
            location = animalDto.location
        )
    }
}