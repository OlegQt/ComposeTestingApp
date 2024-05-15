package com.composetestingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel:ViewModel() {
    private val _state = MutableStateFlow("Init")
    val state = _state.asStateFlow()

    init {
        doInfinite()
    }


    private fun doInfinite(){
        viewModelScope.launch {
            while (true){
                delay(1000)
                _state.emit(Random.nextFloat().toString())
            }
        }
    }
}