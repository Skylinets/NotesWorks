package com.skyline.notesworks.ui.main

import com.skyline.notesworks.data.NotesResponse

sealed class MainState() {
    data object Loading: MainState()
    data class Error(val error: String): MainState()
    data class Notes(val notes: List<NotesResponse>): MainState()
    data object Idle: MainState()
}