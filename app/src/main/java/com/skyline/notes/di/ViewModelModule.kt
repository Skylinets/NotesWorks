package com.skyline.notes.di

import com.skyline.notes.data.NotesRepository
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