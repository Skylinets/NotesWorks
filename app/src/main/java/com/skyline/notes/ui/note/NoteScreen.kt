package com.skyline.notes.ui.note

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.skyline.notes.ui.main.MainState
import com.skyline.notes.viewmodel.MainViewModel

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
            NoteList(notes = viewModel.notes)
        }
        else -> {}
    }
}