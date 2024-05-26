package com.composetestingapp.presentation.fragment.chapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.composetestingapp.presentation.fragment.ListOf
import com.composetestingapp.presentation.fragment.UserInputText

class SettingsFragment : Fragment() {
    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[SettingsViewModel::class.java]

        return ComposeView(requireContext()).apply {
            setContent { FragmentUiContent() }
        }
    }

    @Composable
    fun FragmentUiContent() {
        Column {
            UserInputText(viewModel.inputText, modifier = Modifier.fillMaxWidth()) {
               viewModel.addChapterToList(newChapter = it)
            }

            ListOf(modifier = Modifier.fillMaxWidth(),lst = viewModel.chapterList)
        }
    }
}