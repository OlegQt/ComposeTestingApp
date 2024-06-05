package com.composetestingapp.presentation.fragment.starter

import androidx.lifecycle.ViewModel
import com.composetestingapp.app.App
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StarterViewModel : ViewModel() {
    private val _infoTxt = MutableStateFlow<String>("Loading")
    val infoTxt = _infoTxt.asStateFlow()

    init {
        saveInfo("New string")
        loadInfo()
    }

    private fun loadInfo(){
        App().getSharedPreferences()?.getString(App.SIMPLE_INFO_KEY,"default")

    }

    private fun saveInfo(stringToSave:String){
        App().getSharedPreferences()?.edit()?.putString(App.SIMPLE_INFO_KEY,stringToSave)?.apply()
    }
}
