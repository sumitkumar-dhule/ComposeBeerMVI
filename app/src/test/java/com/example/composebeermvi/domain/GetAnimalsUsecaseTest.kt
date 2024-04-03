package com.example.composebeermvi.domain

import com.example.composebeermvi.domain.model.Animal
import com.example.composebeermvi.domain.usecase.GetAnimalsUsecase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isNotNull

class GetAnimalsUsecaseTest {

    private lateinit var getAnimalsUsecase: GetAnimalsUsecase
    private val animalRepository = mockk<AnimalRepository>()
    private val animal = mockk<Animal>()

    @Before
    fun setup(){
        getAnimalsUsecase = GetAnimalsUsecase(animalRepository)
    }

    @Test
    fun `respository retuns list of animals`() = runTest {
        coEvery { animalRepository.getAnimals() } returns listOf(animal)

        expectThat(getAnimalsUsecase()).isNotNull()
    }
}