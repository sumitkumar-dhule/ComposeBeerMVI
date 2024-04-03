package com.example.composebeermvi.data

import com.example.composebeermvi.data.dto.AnimalDto
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isNotNull

class AnimalRepositoryImplTest {

    private lateinit var animalRepositoryImpl: AnimalRepositoryImpl

    @MockK
    private lateinit var animalApi: AnimalApi

    @MockK
    lateinit var animalDto: AnimalDto

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        animalRepositoryImpl = AnimalRepositoryImpl(animalApi)
    }

    @Test
    fun `when api is called return list of animals`() = runTest {
        val animalList = listOf(animalDto)
        every { animalDto.image } returns "image"
        every { animalDto.name } returns "name"
        every { animalDto.location } returns "location"
        coEvery { animalApi.getAnimals() } returns animalList
        val result = animalRepositoryImpl.getAnimals().first()
        expectThat(result).isNotNull()
    }

}