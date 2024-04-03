package com.example.composebeermvi.domain.usecase

import com.example.composebeermvi.domain.AnimalRepository
import javax.inject.Inject

internal class GetAnimalsUsecase @Inject constructor(private val animalRepository: AnimalRepository) {
    suspend operator fun invoke() = animalRepository.getAnimals()
}