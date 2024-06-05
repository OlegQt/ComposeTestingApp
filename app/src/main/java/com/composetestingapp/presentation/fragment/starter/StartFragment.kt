package com.composetestingapp.presentation.fragment.starter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.composetestingapp.presentation.fragment.ListItem

class StartFragment : Fragment() {
    private lateinit var viewModel:StarterViewModel
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

    @Composable
    fun StartFragmentContent() {

        val infoTxt = viewModel.infoTxt.collectAsState()

        ListItem(
            itemTitle = infoTxt.value,
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .padding(horizontal = 16.dp)
        )
    }

    @Composable
    @Preview(showSystemUi = true)
    fun ContentPreview() {
        ListItem(
            itemTitle = "infoTxt.value",
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .padding(horizontal = 16.dp)
        )
    }
}