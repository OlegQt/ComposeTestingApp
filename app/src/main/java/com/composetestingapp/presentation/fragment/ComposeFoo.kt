package com.composetestingapp.presentation.fragment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputText(
    textLine: MutableStateFlow<String>,
    modifier: Modifier = Modifier,
    addFun: (String) -> Unit
) {
    val text = textLine.collectAsState()

    TextField(
        value = text.value, onValueChange = {
            textLine.value = it
        },
        modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Magenta,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        leadingIcon = {
            IconForInput(
                isEnabled = text.value.isNotEmpty(),
                clickFun = { addFun.invoke(text.value) })
        }

    )
}

@Composable
fun IconForInput(isEnabled: Boolean, clickFun: () -> Unit) {
    val tintColor = if (isEnabled) Color.Magenta else Color.LightGray
    Icon(
        modifier = Modifier.clickable { clickFun.invoke() },
        imageVector = Icons.Default.AddCircle,
        contentDescription = null,
        tint = tintColor
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun UiTextFieldPreview() {
    val internalTxt = MutableStateFlow<String>("Input")
    Column {
        UserInputText(internalTxt) {}
        IconForInput(isEnabled = true) {}
    }
}




