package com.skyline.notesworks.di.module

import com.skyline.notesworks.api.ApiService
import com.skyline.notesworks.data.NotesRepository
import com.skyline.notesworks.di.module.RepositoryService.ApiServiceKey
import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module {
    single(named(ApiServiceKey.name)) { get<ApiService>() }
    single { NotesRepository(apiService = get<ApiService>(named(ApiServiceKey.name))) }
}

enum class RepositoryService {
    ApiServiceKey
}