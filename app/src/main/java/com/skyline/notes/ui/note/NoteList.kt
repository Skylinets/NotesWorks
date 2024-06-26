package com.skyline.notes.ui.note

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skyline.notes.data.NotesResponse
import com.skyline.notes.viewmodel.MainViewModel
import kotlinx.coroutines.flow.StateFlow

@Composable
fun NoteList(notes: StateFlow<List<NotesResponse>>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items = notes.value) { note ->
            Card(shape = RoundedCornerShape(5.dp),
                elevation = 4.dp,
                modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = note.note)
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}
