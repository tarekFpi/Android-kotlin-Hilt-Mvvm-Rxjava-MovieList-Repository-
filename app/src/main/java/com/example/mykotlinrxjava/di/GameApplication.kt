package com.example.mykotlinrxjava.di
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GameApplication :Application(){

    override fun onCreate() {
        super.onCreate()
    }
}