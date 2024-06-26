package com.skyline.notes.ui.main

sealed class MainIntent() {
    data object GetNotes: MainIntent()
}