package com.composetestingapp.app

import android.app.Application
import android.content.SharedPreferences

class App : Application() {
    private var sharedPreferences: SharedPreferences? = null
    override fun onCreate() {
        super.onCreate()

        sharedPreferences = getSharedPreferences(APPLICATION_SHARED_PREFERENCES, MODE_PRIVATE)

    }

    fun getSharedPreferences(): SharedPreferences? = sharedPreferences


    companion object {
        const val APPLICATION_SHARED_PREFERENCES = "app_shared_prefs"
        const val SIMPLE_INFO_KEY = "simple_info_key"
    }
}