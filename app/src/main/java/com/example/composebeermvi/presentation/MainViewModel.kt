package com.example.composebeermvi.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composebeermvi.domain.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val animalRepository: AnimalRepository) :
    ViewModel() {

    var state = mutableStateOf<MainState>(MainState.Loading)
        private set

    init {
        getAnimalsFromRepo()
    }

    private fun getAnimalsFromRepo() {
        viewModelScope.launch {
            state.value = MainState.Loading
            try {
                state.value = MainState.Animals(animalRepository.getAnimals())
            } catch (exception: Exception) {
                state.value = MainState.Error(exception.localizedMessage)
            }
        }
    }
}