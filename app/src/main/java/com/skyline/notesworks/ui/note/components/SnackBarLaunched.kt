package com.skyline.notesworks.ui.note.components

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.skyline.notesworks.ui.main.MainState

@Composable
fun SnackBarLaunched(error: String, state: MainState) {
    val snackBar = remember {
        SnackbarHostState()
    }
    LaunchedEffect(state) {
        snackBar.showSnackbar(
            message = error
        )
    }
}