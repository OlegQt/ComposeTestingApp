package com.composetestingapp.presentation.fragment

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputText(textLine: MutableStateFlow<String>) {
    val text = textLine.collectAsState()

    TextField(
        value = text.value, onValueChange = {
            textLine.value = it
        },
        colors = TextFieldDefaults.textFieldColors(textColor = Color.Magenta)
    )
}