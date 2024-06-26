package com.skyline.notes.ui.note.components

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.skyline.notes.ui.main.MainState

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