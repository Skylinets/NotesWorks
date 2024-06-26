package com.skyline.notes.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.skyline.notes.data.NotesRepository
import com.skyline.notes.viewmodel.MainViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val repository: NotesRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}