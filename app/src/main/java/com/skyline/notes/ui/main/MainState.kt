package com.skyline.notes.ui.main

import com.skyline.notes.data.NotesResponse

sealed class MainState() {
    data object Loading: MainState()
    data class Error(val error: String): MainState()
    data class Notes(val notes: List<NotesResponse>): MainState()
    data object Idle: MainState()
}