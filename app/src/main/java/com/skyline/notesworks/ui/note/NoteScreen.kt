package com.skyline.notesworks.ui.note

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.skyline.notesworks.ui.main.MainState
import com.skyline.notesworks.ui.note.components.DisplayLoading
import com.skyline.notesworks.ui.note.components.SnackBarLaunched
import com.skyline.notesworks.viewmodel.MainViewModel

@Composable
fun NoteScreen(viewModel: MainViewModel) {
    val state by viewModel.state.collectAsState()
    when(val currentState = state){
        is MainState.Error -> {
            if(currentState.error.isNotEmpty()){
                SnackBarLaunched(currentState.error, state)
            }
        }
        MainState.Loading -> DisplayLoading()
        is MainState.Notes -> {
            DisplayNoteList(notes = currentState.notes)
        }
        else -> {}
    }
}