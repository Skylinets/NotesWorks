package com.skyline.notes.api

import com.skyline.notes.data.NotesListResponse
import com.skyline.notes.data.NotesResponse
import retrofit2.http.GET

interface ApiService {
    @GET("notes.json")
    suspend fun getNotes(): NotesListResponse
}