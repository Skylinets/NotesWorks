package com.skyline.notes.di.module

import com.skyline.notes.api.ApiService
import com.skyline.notes.data.NotesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(apiService: ApiService): NotesRepository {
        return NotesRepository(apiService)
    }
}