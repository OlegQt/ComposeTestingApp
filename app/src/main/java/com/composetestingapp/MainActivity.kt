package com.composetestingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            ShowApplicationScreen()
        }
    }

    @Composable
    fun ShowTextLine(txtLine: String) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primaryContainer),
            text = txtLine,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
    }


    @Preview()
    @Composable
    fun ShowPreview() {
        ShowTextLine(txtLine = "Text")
    }


    @Composable
    fun ShowApplicationScreen(){
        val txtVM = viewModel.state.collectAsState()

        ShowTextLine(txtLine =txtVM.value)

    }
}