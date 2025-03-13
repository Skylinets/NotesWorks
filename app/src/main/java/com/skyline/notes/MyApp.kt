package com.skyline.notes

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.skyline.notes.di.module.networkModule
import com.skyline.notes.di.module.repositoryModule
import com.skyline.notes.di.module.viewModelModule
class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
       startKoin {
           androidLogger()
           androidContext(this@MyApp)
           modules(networkModule, repositoryModule, viewModelModule)
       }
    }
}