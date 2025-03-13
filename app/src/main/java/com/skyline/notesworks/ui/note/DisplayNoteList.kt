package com.skyline.notesworks.ui.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skyline.notesworks.BuildConfig
import com.skyline.notesworks.data.NotesResponse

@Composable
fun DisplayNoteList(notes: List<NotesResponse>) {
    Column(Modifier.fillMaxSize()) {
        Text(text = BuildConfig.FLAVOR, fontSize = FontSizeFlavor, color = Color.Red)

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = notes) { note ->
                Card(
                    shape = RoundedCornerShape(ShapeCard),
                    elevation = ElevationCard,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(PaddingCardValues),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = note.note, fontSize = FontSizeItemCard)
                        Spacer(modifier = Modifier.padding(PaddingCardValues))
                    }
                }
            }
        }
    }
}
private val ShapeCard = 5.dp
private val ElevationCard = 4.dp
private val PaddingCardValues = 7.dp
private val FontSizeFlavor = 25.sp
private val FontSizeItemCard = 15.sp
