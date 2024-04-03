package com.example.composebeermvi.data.mapper

import com.example.composebeermvi.data.dto.AnimalDto
import com.example.composebeermvi.domain.model.Animal
import javax.inject.Inject

class AnimalMapper @Inject constructor() {
    fun mapAnimal(animalDto: AnimalDto): Animal =
        Animal(animalDto.name, animalDto.location, animalDto.image)
}