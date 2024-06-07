package com.composetestingapp.presentation.fragment.starter

import androidx.lifecycle.ViewModel
import com.composetestingapp.app.App
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StarterViewModel : ViewModel() {
    val _infoTxt = MutableStateFlow<String>("Loading")
    val infoTxt = _infoTxt.asStateFlow()

    init {
        //saveInfo("New string")
        loadInfo()
    }

    private fun loadInfo(){
        App().getSharedPreferences()?.let {
            _infoTxt.value = it.getString(App.SIMPLE_INFO_KEY,"default").toString()
        }

    }

    private fun saveInfo(stringToSave:String){
        App().getSharedPreferences()?.edit()?.putString(App.SIMPLE_INFO_KEY,stringToSave)?.apply()
    }
}
