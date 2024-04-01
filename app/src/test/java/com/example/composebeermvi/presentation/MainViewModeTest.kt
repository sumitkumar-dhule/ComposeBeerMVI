package com.example.composebeermvi.presentation

import com.example.composebeermvi.domain.AnimalRepository
import com.example.composebeermvi.domain.model.Animal
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

@OptIn(ExperimentalCoroutinesApi::class)

class MainViewModelTest {

    private val animalRepository = mockk<AnimalRepository>()
    private val animal = mockk<Animal>()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun `when success to get animal list`() = runTest {
        val animals = listOf(animal)
        coEvery { animalRepository.getAnimals() } returns animals

        val mainViewModel = MainViewModel(animalRepository)

        expectThat(mainViewModel.state.value).isEqualTo(MainState.Animals(animals))
    }
}