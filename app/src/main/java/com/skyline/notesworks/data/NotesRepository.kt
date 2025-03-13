package com.skyline.notesworks.data

import com.skyline.notesworks.api.ApiService

class NotesRepository(private val apiService: ApiService) {
    suspend fun getNotes(): NotesListResponse = apiService.getNotes()
}