package com.skyline.notes.di

import android.app.Application
import android.content.Context
import com.skyline.notes.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application, @BindsInstance context: Context): AppComponent
    }
}