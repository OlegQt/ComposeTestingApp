package com.composetestingapp.presentation.fragment.chapter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel : ViewModel() {
    val inputText = MutableStateFlow("")
}