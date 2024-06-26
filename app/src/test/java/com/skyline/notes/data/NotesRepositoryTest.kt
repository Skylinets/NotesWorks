package com.skyline.notes.data

import com.skyline.notes.api.ApiService
import com.skyline.notes.factory.NotesFactory.loadList
import com.skyline.notes.viewmodel.MainViewModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

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

    fun stubRepository(notes: NotesListResponse){
        coEvery { repository.getNotes() } returns notes
    }
    fun stubApiService(notes: NotesListResponse){
        coEvery { apiService.getNotes() } returns notes
    }
}