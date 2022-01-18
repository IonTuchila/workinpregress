package com.example.workinprogress

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm

@HiltAndroidApp
class WorkApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
    }

}