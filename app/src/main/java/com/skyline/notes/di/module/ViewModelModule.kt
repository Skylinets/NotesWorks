package com.skyline.notes.di.module

import com.skyline.notes.data.NotesRepository
import com.skyline.notes.di.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ViewModelModule {
    @Provides
    @Singleton
    fun provideViewModelFactory(repository: NotesRepository): ViewModelFactory {
        return ViewModelFactory(repository)
    }
}