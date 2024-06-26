package com.skyline.notes.data

import com.skyline.notes.api.ApiService
import javax.inject.Inject

class NotesRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getNotes(): NotesListResponse = apiService.getNotes()
}