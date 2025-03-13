package com.skyline.notesworks.data

import com.skyline.notesworks.api.ApiService
import com.skyline.notesworks.factory.NotesFactory.loadList
import com.skyline.notesworks.viewmodel.MainViewModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NotesRepositoryTest {

    lateinit var repository: NotesRepository
    lateinit var apiService: ApiService
    lateinit var mainViewModel: MainViewModel

    @Before
    fun setup(){
        apiService = mockk()
        repository = NotesRepository(apiService)
        mainViewModel = MainViewModel(repository)
    }
    @After
    fun tearDown(){
        clearAllMocks()
    }
    @Test
    fun`getNotes is error`() = runTest {
        val expected = NotesListResponse(emptyList())
        stubApiService(expected)

        val result = repository.getNotes()
        assertEquals(expected, result)
    }
    @Test
    fun`getNotes is success`() = runTest {
        val expected = loadList()
        stubApiService(expected)
        stubRepository(expected)
        val result = repository.getNotes()
        assertEquals(expected, result)
    }

    private fun stubRepository(notes: NotesListResponse){
        coEvery { repository.getNotes() } returns notes
    }
    private fun stubApiService(notes: NotesListResponse){
        coEvery { apiService.getNotes() } returns notes
    }
}