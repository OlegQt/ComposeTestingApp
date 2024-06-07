package com.composetestingapp.presentation.fragment.starter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class StartFragment : Fragment() {
    private lateinit var viewModel: StarterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[StarterViewModel::class.java]

        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent { StartFragmentContent() }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun StartFragmentContent() {
        val inputText by remember { mutableStateOf("Text") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            TextField(
                value = inputText,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), //dimensionResource(id = R.dimen.user_input_horizontal_padding)
                shape = RoundedCornerShape(16.dp)
            )
        }


    }

    @Composable
    @Preview(showSystemUi = true)
    fun ContentPreview() {
        StartFragmentContent()
    }
}