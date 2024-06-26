package com.skyline.notes.data

import com.skyline.notes.api.ApiService
import retrofit2.Response
import javax.inject.Inject

class NotesRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getNotes(): NotesListResponse = apiService.getNotes()
}