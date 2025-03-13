package com.skyline.notes.di.module

import com.skyline.notes.api.ApiService
import com.skyline.notes.data.NotesRepository
import com.skyline.notes.di.module.RepositoryService.ApiServiceKey
import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module {
    single(named(ApiServiceKey.name)) { get<ApiService>() }
    single { NotesRepository(apiService = get<ApiService>(named(ApiServiceKey.name))) }
}

enum class RepositoryService {
    ApiServiceKey
}