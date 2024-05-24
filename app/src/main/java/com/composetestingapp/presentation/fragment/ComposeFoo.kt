package com.composetestingapp.presentation.fragment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun UiTextFieldPreview() {
    Column {
        UiUserInput()
        UiUserInput()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiUserInput() {
    var txt by remember { mutableStateOf("Text") }
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Gray)
    ) {
        TextField(
            modifier = Modifier.padding(16.dp),
            value = txt,
            onValueChange = { txt = it }
        )
    }
}
