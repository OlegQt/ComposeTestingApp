package com.composetestingapp.presentation.fragment.chapter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel : ViewModel() {
    val inputText = MutableStateFlow("")
    val chapterList = MutableStateFlow(mutableListOf<String>())

    fun addChapterToList(newChapter: String) {
        val list = mutableListOf<String>()
        list.addAll(chapterList.value)
        list.add(newChapter)
        chapterList.value = list
    }
}