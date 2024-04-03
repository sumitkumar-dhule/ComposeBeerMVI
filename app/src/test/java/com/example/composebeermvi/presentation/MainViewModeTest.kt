package com.example.composebeermvi.presentation

import com.example.composebeermvi.MainDispatcherRule
import com.example.composebeermvi.domain.model.Animal
import com.example.composebeermvi.domain.usecase.GetAnimalsUsecase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.io.IOException

class MainViewModelTest {

    private val animalsUsecase = mockk<GetAnimalsUsecase>()
    private val animal = mockk<Animal>()

    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `when success to get animal list`() = runTest {
        val animals = listOf(animal)
        coEvery { animalsUsecase() } returns animals

        val mainViewModel = MainViewModel(animalsUsecase)

        expectThat(mainViewModel.state.value).isEqualTo(MainState.Animals(animals))
    }

    @Test
    fun `when fail to get animal list`() = runTest {
        val msg = "msg"
        coEvery { animalsUsecase() } throws  IOException(msg)

        val mainViewModel = MainViewModel(animalsUsecase)

        expectThat(mainViewModel.state.value).isEqualTo(MainState.Error(msg))
    }

}