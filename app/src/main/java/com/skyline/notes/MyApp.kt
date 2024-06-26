package com.skyline.notes

import android.app.Application
import com.skyline.notes.di.AppComponent
import com.skyline.notes.di.DaggerAppComponent

class MyApp: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this, applicationContext)
    }
}