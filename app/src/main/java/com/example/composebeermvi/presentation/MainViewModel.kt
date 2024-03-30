package com.example.composebeermvi.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composebeermvi.domain.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val animalRepository: AnimalRepository) : ViewModel() {

    var state = mutableStateOf<MainState>(MainState.Loading)
        private set

    init {
        getBeers()
    }

    private fun getBeers() {
        viewModelScope.launch {
            state.value = MainState.Loading
            state.value = try {
                MainState.Beers(animalRepository.getAnimals())
            } catch (exception: Exception) {
                MainState.Error(exception.localizedMessage)
            }
        }
    }
}