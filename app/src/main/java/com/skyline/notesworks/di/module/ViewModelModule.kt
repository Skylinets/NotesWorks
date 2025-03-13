package com.skyline.notesworks.di.module

import com.skyline.notesworks.data.NotesRepository
import com.skyline.notesworks.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get<NotesRepository>()) }
}

