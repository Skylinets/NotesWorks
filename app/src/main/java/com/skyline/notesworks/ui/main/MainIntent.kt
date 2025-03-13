package com.skyline.notesworks.ui.main

sealed class MainIntent() {
    data object GetNotes: MainIntent()
}