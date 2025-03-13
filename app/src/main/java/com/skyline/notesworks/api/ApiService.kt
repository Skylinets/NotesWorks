package com.skyline.notesworks.api

import com.skyline.notesworks.data.NotesListResponse
import retrofit2.http.GET

interface ApiService {
    @GET("notes.json")
    suspend fun getNotes(): NotesListResponse
}