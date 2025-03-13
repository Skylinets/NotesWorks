package com.skyline.notesworks.factory

import com.skyline.notesworks.data.NotesListResponse
import com.skyline.notesworks.data.NotesResponse

object NotesFactory {

    fun loadList(): NotesListResponse {
        val notes = listOf(
            NotesResponse(id = "01", note = "nota 1", content = "contenido 1"),
            NotesResponse(id = "02", note = "nota 2", content = "contenido 2"),
            NotesResponse(id = "03", note = "nota 3", content = "contenido 3"),
            NotesResponse(id = "04", note = "nota 4", content = "contenido 4")
        )
        return NotesListResponse(notes)
    }
}