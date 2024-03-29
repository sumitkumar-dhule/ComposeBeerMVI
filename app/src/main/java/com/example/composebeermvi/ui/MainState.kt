package com.example.composebeermvi.ui

import com.sample.domain.model.Beer

sealed class MainState {
    data object Loading : MainState()
    data class Beers(val list: List<Beer>) : MainState()
    data class Error(val msg: String) : MainState()
}
