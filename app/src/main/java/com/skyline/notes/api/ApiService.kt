package com.skyline.notes.api

import com.skyline.notes.data.NotesListResponse
import retrofit2.http.GET

interface ApiService {
    @GET("notes.json")
    suspend fun getNotes(): NotesListResponse
}