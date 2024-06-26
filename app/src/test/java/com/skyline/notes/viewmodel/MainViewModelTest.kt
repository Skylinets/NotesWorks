package com.skyline.notes.viewmodel

import com.skyline.notes.data.NotesListResponse
import com.skyline.notes.data.NotesRepository
import com.skyline.notes.factory.NotesFactory.loadList
import com.skyline.notes.ui.main.MainState
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var repository: NotesRepository
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup(){
        repository = mockk()
        mainViewModel = MainViewModel(repository)
    }
    @After
    fun tearDown(){
        clearAllMocks()
    }
    @Test
    fun`getNotes is success`() = runTest {
        val note = loadList()
        stubRepository(note)
        val result = mainViewModel.getNotes()

        val expected = MainState.Notes(note.notes)
        assertEquals(expected.notes, result.notes)
    }
    @Test
    fun`updateUi is success`() = runTest {
        val note = loadList()
        stubRepository(note)
        val result = MainState.Notes(note.notes)
        mainViewModel.updateUiWithNames(note.notes)

        val expected = mainViewModel.state.value
        assertEquals(expected, result)
    }
    @Test
    fun`updateUi is error`() = runTest {
        val note = NotesListResponse(emptyList())
        stubRepository(note)
        val result = MainState.Error("Error not notes founds")
        mainViewModel.updateUiWithNames(note.notes)

        val expected = mainViewModel.state.value
        assertEquals(expected, result)
    }

    @Test
    fun `getNotes error`()= runTest {
        val errorMessage = "Error"
        coEvery { repository.getNotes() } throws RuntimeException(errorMessage)
        val actual = kotlin.runCatching { mainViewModel.getNotes() }
        assertEquals(errorMessage, actual.exceptionOrNull()?.message)
    }
    private fun stubRepository(notes: NotesListResponse){
        coEvery { repository.getNotes() } returns notes
    }
}