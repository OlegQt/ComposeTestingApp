package com.composetestingapp.presentation.fragment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composetestingapp.R
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
        modifier = modifier.padding(
            horizontal = 16.dp,
            vertical = 8.dp
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.DarkGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color.LightGray
        ),
        shape = RoundedCornerShape(16.dp),
        textStyle = TextStyle(fontSize = 18.sp),
        leadingIcon = {
            IconAddToDB(
                modifier = Modifier.clickable { addFun.invoke(text.value) },
                isEnabled = text.value.isNotEmpty()
            )
        },
        trailingIcon = {
            ClearText(isEnabled = text.value.isNotEmpty(),
                modifier = Modifier.clickable { textLine.value = "" })
        }
    )
}

@Composable
fun IconAddToDB(modifier: Modifier = Modifier, isEnabled: Boolean) {
    val tintColor = if (isEnabled) Color.Magenta else Color.DarkGray
    Icon(
        modifier = modifier,
        imageVector = Icons.Default.AddCircle,
        contentDescription = stringResource(id = R.string.button_add_to_db_name),
        tint = tintColor
    )
}

@Composable
fun ClearText(modifier: Modifier = Modifier, isEnabled: Boolean) {
    val tintColor = if (isEnabled) Color.Magenta else Color.DarkGray
    Icon(
        modifier = modifier,
        imageVector = Icons.Default.Delete,
        contentDescription = stringResource(id = R.string.button_clear_txt),
        tint = tintColor
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun UiTextFieldPreview() {
    val internalTxt = MutableStateFlow<String>("Input")
    Column {
        UserInputText(internalTxt, Modifier.fillMaxWidth()) {}
    }
}




