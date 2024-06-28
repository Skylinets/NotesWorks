package com.skyline.notes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skyline.notes.data.NotesListResponse
import com.skyline.notes.data.NotesRepository
import com.skyline.notes.data.NotesResponse
import com.skyline.notes.ui.main.MainIntent
import com.skyline.notes.ui.main.MainState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: NotesRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<MainState>(MainState.Idle)
    val state: StateFlow<MainState> = _state.asStateFlow()

    private val userIntent = Channel<MainIntent>(Channel.UNLIMITED)

    private val _notes = MutableStateFlow<List<NotesResponse>>(emptyList())

    init {
        handleIntent()
        sendIntent(MainIntent.GetNotes)
    }

    private fun sendIntent(intent: MainIntent) {
        viewModelScope.launch(Dispatchers.Default) {
            userIntent.send(intent)
        }
    }

    private fun handleIntent() {
        viewModelScope.launch(Dispatchers.Default) {
            userIntent.consumeAsFlow().collect { intent ->
                when (intent) {
                    is MainIntent.GetNotes -> loadMockNotes()
                }
            }
        }
    }

    internal fun loadMockNotes() {
        viewModelScope.launch(Dispatchers.Default) {
            _state.value = MainState.Loading
            try {
                _notes.value = getNotes().notes
                updateUiWithNames(_notes.value)
            } catch (e: Exception){
                handleGetError(e)
            }

        }
    }

    internal fun updateUiWithNames(notes: List<NotesResponse>) {
        if (notes.isNotEmpty()) {
            _state.value = MainState.Notes(notes = notes)
        } else {
            handleGetError(RuntimeException("Error not notes founds"))
        }
    }

    internal suspend fun getNotes(): NotesListResponse {
        val notesResponse = repository.getNotes()
        if (notesResponse.notes.isNotEmpty()) {
            return notesResponse
        } else {
            throw RuntimeException("Error")
        }
    }

    private fun handleGetError(e: Exception) {
        _state.value = MainState.Error(e.localizedMessage ?: "Error get note")
    }
}